package com.datawisher.bee.voice.service;

import com.datawisher.bee.voice.model.VoiceModel;

public interface VoiceService {
    /**
     * 播放和存储语音消息
     *
     * @param voiceModel 语音模型
     * @throws Exception 异常信息
     */
    void playAndSaveVoice(VoiceModel voiceModel) throws Exception;
}
