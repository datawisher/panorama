package com.datawisher.bee.voice.service;

import com.datawisher.bee.voice.config.VoiceProperties;
import com.datawisher.bee.voice.model.VoiceModel;
import com.datawisher.bee.voice.ui.home.HomeFrame;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
    public void playAndSaveVoice(VoiceModel voiceModel) {
        // 调用TTS进行语音播放
        playVoice(voiceModel);
        // 根据操作是否存储音频
        String selectedItem = (String) homeFrame.getVoiceCbx().getSelectedItem();
        if ("存储".equalsIgnoreCase(selectedItem)) {
            saveVoice(voiceModel);
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
        Integer volume = voiceModel.getVolume();
        if (Objects.isNull(volume)) {
            String volumeText = homeFrame.getVolumeTxf().getText();
            if (NumberUtils.isParsable(volumeText)) {
                ax.setProperty("Volume", new Variant(Integer.parseInt(volumeText)));
            }
        } else {
            ax.setProperty("Volume", new Variant(volume));
        }
        // 语速 -10 到 +10
        Integer rate = voiceModel.getRate();
        if (Objects.isNull(rate)) {
            String rateText = homeFrame.getRateTxf().getText();
            if (NumberUtils.isParsable(rateText)) {
                ax.setProperty("Rate", new Variant(Integer.parseInt(rateText)));
            }
        } else {
            ax.setProperty("Rate", new Variant(voiceModel.getRate()));
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
    public String saveVoice(VoiceModel voiceModel) {
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = "voice" + dateFormat.format(new Date()) + ".wav";
        String path = voiceProperties.getPath() + fileName;
        Dispatch.call(spFileStream, "Open", new Variant(path), new Variant(3), new Variant(false));

        // 设置声音对象的音频输出流为输出文件对象
        ax = new ActiveXComponent("Sapi.SpVoice");
        Dispatch spVoice = ax.getObject();
        Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
        Dispatch.put(spVoice, "Volume", new Variant(voiceModel.getVolume()));
        Dispatch.put(spVoice, "Rate", new Variant(voiceModel.getRate()));
        Dispatch.call(spVoice, "Speak", new Variant(voiceModel.getTextContent()));
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
