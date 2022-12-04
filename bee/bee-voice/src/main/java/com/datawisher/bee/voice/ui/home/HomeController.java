package com.datawisher.bee.voice.ui.home;

import com.datawisher.bee.voice.config.VoiceProperties;
import com.datawisher.bee.voice.model.VoiceModel;
import com.datawisher.bee.voice.service.VoiceService;
import com.datawisher.bee.voice.ui.AbstractController;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;

@Controller
public class HomeController extends AbstractController {

    private final HomeFrame homeFrame;
    private final VoiceService voiceService;
    private final VoiceProperties voiceProperties;

    public HomeController(HomeFrame homeFrame, VoiceService voiceService, VoiceProperties voiceProperties) {
        this.homeFrame = homeFrame;
        this.voiceService = voiceService;
        this.voiceProperties = voiceProperties;
    }

    @Override
    public void prepareAndOpenFrame() {
        // 初始化组件
        initializeHomeJFrame();

        // 注册监听器
        registerAction(homeFrame.getConfirmBtn(), confirmBtnAction());
        registerAction(homeFrame.getTestBtn(), testBtnAction());

        // 使用系统托盘
        homeFrame.setVisible(true);
    }


    private ActionListener confirmBtnAction() {
        return e -> {
            String volumeText = homeFrame.getVolumeTxf().getText();
            if (!NumberUtils.isParsable(volumeText)) {
                JOptionPane.showMessageDialog(homeFrame, "音量的可选值区间为0到100以内！", "错误提示", JOptionPane.ERROR_MESSAGE);
            } else {
                int volume = Integer.parseInt(volumeText);
                if (0 > volume || 100 < volume) {
                    JOptionPane.showMessageDialog(homeFrame, "音量的可选值区间为0到100以内！", "错误提示", JOptionPane.ERROR_MESSAGE);
                }
            }
            String rateText = homeFrame.getRateTxf().getText();
            if (!NumberUtils.isParsable(rateText)) {
                JOptionPane.showMessageDialog(homeFrame, "速率的可选值区间为-10到+10以内！", "错误提示", JOptionPane.ERROR_MESSAGE);
            } else {
                int rate = Integer.parseInt(rateText);
                if (-10 > rate || 10 < rate) {
                    JOptionPane.showMessageDialog(homeFrame, "速率的可选值区间为-10到+10以内！", "错误提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }

    private ActionListener testBtnAction() {
        return e -> {
            String content = homeFrame.getTestTextArea().getText();
            if (StringUtils.isNotBlank(content)) {
                String volumeText = homeFrame.getVolumeTxf().getText();
                String rateText = homeFrame.getRateTxf().getText();
                VoiceModel voiceModel = new VoiceModel();
                voiceModel.setTextContent(content);
                if (NumberUtils.isParsable(volumeText)) {
                    voiceModel.setVolume(Integer.parseInt(volumeText));
                } else {
                    voiceModel.setVolume(voiceProperties.getVolume());
                }
                if (NumberUtils.isParsable(rateText)) {
                    voiceModel.setRate(Integer.parseInt(rateText));
                } else {
                    voiceModel.setRate(voiceProperties.getRate());
                }
                voiceService.playAndSaveVoice(voiceModel);
            }
        };
    }

    private void initializeHomeJFrame() {
        homeFrame.getSpotTxf().setText(voiceProperties.getSpot());
        homeFrame.getVolumeTxf().setText(voiceProperties.getVolume() + "");
        homeFrame.getRateTxf().setText(voiceProperties.getRate() + "");
        Boolean save = voiceProperties.getSave();
        if (save) {
            homeFrame.getVoiceCbx().setSelectedItem("存储");
        } else {
            homeFrame.getVoiceCbx().setSelectedItem("丢弃");
        }
    }
}
