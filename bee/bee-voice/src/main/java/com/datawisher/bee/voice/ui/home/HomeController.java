package com.datawisher.bee.voice.ui.home;

import com.datawisher.bee.voice.config.VoiceProperties;
import com.datawisher.bee.voice.model.VoiceModel;
import com.datawisher.bee.voice.service.VoiceService;
import com.datawisher.bee.voice.ui.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

@Slf4j
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
        registerAction(homeFrame.getDirTxf(), dirSelectAction());
        registerAction(homeFrame.getConfirmBtn(), confirmBtnAction());
        registerAction(homeFrame.getTestBtn(), testBtnAction());

        // 使用系统托盘
        homeFrame.setVisible(false);
    }

    private MouseListener dirSelectAction() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JFileChooser fileChooser = new JFileChooser(voiceProperties.getDirectory());
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int result = fileChooser.showSaveDialog(homeFrame);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        homeFrame.getDirTxf().setText(selectedFile.getAbsolutePath());
                    }
                }
            }
        };
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
                JOptionPane.showMessageDialog(homeFrame, "音速的可选值区间为-10到+10以内！", "错误提示", JOptionPane.ERROR_MESSAGE);
            } else {
                int rate = Integer.parseInt(rateText);
                if (-10 > rate || 10 < rate) {
                    JOptionPane.showMessageDialog(homeFrame, "音速的可选值区间为-10到+10以内！", "错误提示", JOptionPane.ERROR_MESSAGE);
                }
            }
            String ratioText = homeFrame.getRatioTxf().getText();
            if (!NumberUtils.isParsable(rateText)) {
                JOptionPane.showMessageDialog(homeFrame, "倍率的可选值区间为1到100以内！", "错误提示", JOptionPane.ERROR_MESSAGE);
            } else {
                float ratio = Float.parseFloat(ratioText);
                if (1f > ratio || 100f < ratio) {
                    JOptionPane.showMessageDialog(homeFrame, "倍率的可选值区间为1到100以内！", "错误提示", JOptionPane.ERROR_MESSAGE);
                }
            }
            String voiceText = (String) homeFrame.getVoiceCbx().getSelectedItem();
            String pathText = homeFrame.getDirTxf().getText();
            if ("存储".equalsIgnoreCase(voiceText) && StringUtils.isBlank(pathText)) {
                JOptionPane.showMessageDialog(homeFrame, "音频的储存目录不能为空！", "错误提示", JOptionPane.ERROR_MESSAGE);
            }
        };
    }

    private ActionListener testBtnAction() {
        return e -> {
            String content = homeFrame.getTestTextArea().getText();
            if (StringUtils.isNotBlank(content)) {
                VoiceModel voiceModel = new VoiceModel(content);
                try {
                    voiceService.playAndSaveVoice(voiceModel);
                } catch (Exception exception) {
                    log.error("测试播放语音时遇到错误:[{}]", exception.getMessage());
                }
            }
        };
    }

    private void initializeHomeJFrame() {
        homeFrame.getSpotTxf().setText(voiceProperties.getSpot());
        homeFrame.getVolumeTxf().setText(voiceProperties.getVolume() + "");
        homeFrame.getRateTxf().setText(voiceProperties.getRate() + "");
        homeFrame.getRatioTxf().setText(voiceProperties.getRatio() + "");
        homeFrame.getDirTxf().setText(voiceProperties.getDirectory());
        Boolean save = voiceProperties.getSave();
        if (save) {
            homeFrame.getVoiceCbx().setSelectedItem("存储");
        } else {
            homeFrame.getVoiceCbx().setSelectedItem("丢弃");
        }
    }

}
