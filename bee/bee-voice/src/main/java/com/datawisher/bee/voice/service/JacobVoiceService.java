package com.datawisher.bee.voice.service;

import com.datawisher.bee.voice.model.VoiceModel;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author h407644
 * @date 2022-11-25
 */
@Component
public class JacobVoiceService {

    @Value("${voice.path}")
    private String voicePath;

    /**
     * 播放语音
     */
    public void playVoice(VoiceModel voiceModel) {
        ActiveXComponent ax;
        // 微软SAPI接口
        ax = new ActiveXComponent("Sapi.SpVoice");
        // 音量 0-100
        ax.setProperty("Volume", new Variant(voiceModel.getVolume()));
        // 语速 -10 到 +10
        ax.setProperty("Rate", new Variant(voiceModel.getRate()));
        // 调用 spVoice 播报
        Dispatch spVoice = ax.getObject();
        Dispatch.call(spVoice, "Speak", new Variant(voiceModel.getTextContent()));
        spVoice.safeRelease();
        ax.safeRelease();
    }

    /**
     * 生成语音文件
     */
    public void saveVoice(VoiceModel voiceModel) {
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
        String path = voicePath + fileName;
        Dispatch.call(spFileStream, "Open", new Variant(path), new Variant(3), new Variant(false));

        // 设置声音对象的音频输出流为输出文件对象
        ax = new ActiveXComponent("Sapi.SpVoice");
        Dispatch spVoice = ax.getObject();
        Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
        Dispatch.put(spVoice,"Volume", new Variant(voiceModel.getVolume()));
        Dispatch.put(spVoice,"Rate", new Variant(voiceModel.getRate()));
        Dispatch.call(spVoice, "Speak", new Variant(voiceModel.getTextContent()));
        // 关闭输出文件
        Dispatch.call(spFileStream, "Close");
        Dispatch.putRef(spVoice, "AudioOutputStream", null);
        spAudioFormat.safeRelease();
        spFileStream.safeRelease();
        spVoice.safeRelease();
        ax.safeRelease();
    }

}
