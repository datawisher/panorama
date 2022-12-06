package com.datawisher.bee.voice.model;

import java.io.Serializable;

/**
 * @author h407644
 * @date 2022-11-24
 */
public class VoiceModel implements Serializable {
    /**
     * 文本消息
     */
    private String textContent;

    public VoiceModel() {
    }

    public VoiceModel(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
