package com.datawisher.bee.voice.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.datawisher.bee.voice.config.VoiceProperties;
import com.datawisher.bee.voice.model.VoiceModel;
import com.datawisher.bee.voice.ui.home.HomeFrame;
import com.datawisher.bee.voice.utils.PlaySoundUtil;
import com.datawisher.bee.voice.utils.RaiseVolumeUtil;
import com.google.common.base.Joiner;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;

/**
 * @author h407644
 * @date 2022-11-25
 */
@Service
public class JacobVoiceService implements VoiceService {
    private final HomeFrame homeFrame;
    private final VoiceProperties voiceProperties;

    public JacobVoiceService(HomeFrame homeFrame, VoiceProperties voiceProperties) {
        this.homeFrame = homeFrame;
        this.voiceProperties = voiceProperties;
    }

    @Override
    public void playAndSaveVoice(VoiceModel voiceModel) throws Exception {
        // 保存原始的音频文件
        String originalVoicePath = saveOriginalVoice(voiceModel);
        if (StringUtils.isNotBlank(originalVoicePath)) {
            String dirValue = voiceProperties.getDirectory();
            String dirText = homeFrame.getDirTxf().getText();
            if (StringUtils.isNotBlank(dirText)) {
                dirValue = dirText;
            }
            Float ratioValue = voiceProperties.getRatio();
            String ratioText = homeFrame.getRatioTxf().getText();
            if (StringUtils.isNotBlank(ratioText)) {
                ratioValue = NumberUtils.toFloat(ratioText, voiceProperties.getRatio());
            }
            // 生成扩音后的音频文件
            String raiseVoicePath = RaiseVolumeUtil.raiseByRatio(originalVoicePath, dirValue, ratioValue);
            if (StringUtils.isNotBlank(raiseVoicePath)) {
                // 删除原始的音频文件
                FileUtil.del(originalVoicePath);
                // 播放扩音后的语音消息
                PlaySoundUtil.play(raiseVoicePath);
            }
            // 是否存储扩音的音频文件
            String selectedItem = (String) homeFrame.getVoiceCbx().getSelectedItem();
            if ("丢弃".equalsIgnoreCase(selectedItem)) {
                FileUtil.del(raiseVoicePath);
            }
        }
    }

    /**
     * 播放语音
     */
    public void playVoice(VoiceModel voiceModel) {
        ActiveXComponent ax;
        // 微软SAPI接口
        ax = new ActiveXComponent("Sapi.SpVoice");
        // 音量 0-100
        String volumeText = homeFrame.getVolumeTxf().getText();
        if (NumberUtils.isParsable(volumeText)) {
            ax.setProperty("Volume", new Variant(Integer.parseInt(volumeText)));
        } else {
            ax.setProperty("Volume", new Variant(voiceProperties.getVolume()));
        }
        // 语速 -10 到 +10
        String rateText = homeFrame.getRateTxf().getText();
        if (NumberUtils.isParsable(rateText)) {
            ax.setProperty("Rate", new Variant(Integer.parseInt(rateText)));
        } else {
            ax.setProperty("Rate", new Variant(voiceProperties.getRate()));
        }
        // 调用 spVoice 播报
        Dispatch spVoice = ax.getObject();
        Dispatch.call(spVoice, "Speak", new Variant(voiceModel.getTextContent()));
        spVoice.safeRelease();
        ax.safeRelease();
    }

    /**
     * 生成语音文件
     */
    public String saveOriginalVoice(VoiceModel voiceModel) {
        ActiveXComponent ax;
        // 生成语音流
        ax = new ActiveXComponent("Sapi.SpFileStream");
        Dispatch spFileStream = ax.getObject();
        ax = new ActiveXComponent("Sapi.SpAudioFormat");
        Dispatch spAudioFormat = ax.getObject();
        // 设置音频流格式，SAFT22kHz16BitMono = 22
        Dispatch.put(spAudioFormat, "Type", new Variant(22));
        // 设置文件输出流格式
        Dispatch.putRef(spFileStream, "Format", spAudioFormat);
        // 创建一个语音文件
        String dirValue = voiceProperties.getDirectory();
        String dirText = homeFrame.getDirTxf().getText();
        if (StringUtils.isNotBlank(dirText)) {
            dirValue = dirText;
        }
        String path = Joiner.on(File.separator).join(Arrays.asList(dirValue, IdUtil.simpleUUID() + "." + ".wav"));
        Dispatch.call(spFileStream, "Open", new Variant(path), new Variant(3), new Variant(false));
        // 设置声音对象的音频输出流为输出文件对象
        ax = new ActiveXComponent("Sapi.SpVoice");
        Dispatch spVoice = ax.getObject();
        Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
        Dispatch.call(spVoice, "Speak", new Variant(voiceModel.getTextContent()));
        // 音量 0-100
        String volumeText = homeFrame.getVolumeTxf().getText();
        if (NumberUtils.isParsable(volumeText)) {
            ax.setProperty("Volume", new Variant(Integer.parseInt(volumeText)));
            Dispatch.put(spVoice, "Volume", new Variant(Integer.parseInt(volumeText)));
        } else {
            Dispatch.put(spVoice, "Volume", new Variant(voiceProperties.getVolume()));
        }
        // 语速 -10 到 +10
        String rateText = homeFrame.getRateTxf().getText();
        if (NumberUtils.isParsable(rateText)) {
            Dispatch.put(spVoice, "Rate", new Variant(Integer.parseInt(rateText)));
        } else {
            Dispatch.put(spVoice, "Rate", new Variant(voiceProperties.getRate()));
        }

        // 关闭输出文件
        Dispatch.call(spFileStream, "Close");
        Dispatch.putRef(spVoice, "AudioOutputStream", null);
        spAudioFormat.safeRelease();
        spFileStream.safeRelease();
        spVoice.safeRelease();
        ax.safeRelease();

        return path;
    }

}
