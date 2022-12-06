package com.datawisher.bee.voice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "voice")
public class VoiceProperties {
    /**
     * 站点名称
     */
    private String spot;
    /**
     * 保存音频
     */
    private Boolean save = Boolean.FALSE;
    /**
     * 音频路径
     */
    private String directory = "C:/VoiceStore";
    /**
     * 播放音量
     */
    private Integer volume = 100;
    /**
     * 播放速率
     */
    private Integer rate = -2;
    /**
     * 倍率音量
     */
    private Float ratio = 7f;

}
