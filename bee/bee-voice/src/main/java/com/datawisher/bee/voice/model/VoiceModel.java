package com.datawisher.bee.voice.model;

/**
 * @author h407644
 * @date 2022-11-24
 */
public class VoiceModel {

    private String textContent;

    private Integer volume;

    private Integer rate;

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
