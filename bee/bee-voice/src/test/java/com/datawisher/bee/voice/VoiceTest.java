package com.datawisher.bee.voice;

import com.datawisher.bee.voice.util.PlaySoundUtil;
import com.datawisher.bee.voice.util.RaiseVolumeUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 播放wav文件
 *
 * @author h407644
 * @date 2022-11-28
 */
public class VoiceTest {

    String audioPath;

    @BeforeEach
    void init() {
        audioPath = "/opt/sample.wav";
    }

    @Test
    public void raiseVolume() throws Exception {
        String raisedFilePath = RaiseVolumeUtil.raiseByRatio("/opt/sample.wav", "/opt", 6);
        PlaySoundUtil.play(raisedFilePath);
    }

}
