package com.datawisher.bee.voice.utils;

import cn.hutool.core.util.IdUtil;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.bytedeco.javacpp.Loader;

import java.io.File;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class RaiseVolumeUtil {
    /**
     * 通过倍率提升音量
     *
     * @param audioPath 音频地址
     * @param outputDir 输出目录
     * @param ratio     倍率音量
     * @return 音频地址
     * @throws Exception 异常
     */
    @SuppressWarnings("all")
    public static String raiseByRatio(String audioPath, String outputDir, float ratio) throws Exception {
        List<String> paths = Splitter.on(".").splitToList(audioPath);
        String ext = paths.get(paths.size() - 1);
        if (!Arrays.asList("wav", "mp3").contains(ext)) {
            throw new Exception("format error");
        }
        String resultPath = Joiner.on(File.separator).join(Arrays.asList(outputDir, IdUtil.simpleUUID() + "." + ext));
        String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);
        ProcessBuilder builder =
                new ProcessBuilder(
                        ffmpeg,
                        "-i",
                        audioPath,
                        "-filter:a",
                        MessageFormat.format("volume={0}", String.valueOf(ratio)),
                        resultPath);
        builder.inheritIO().start().waitFor();
        return resultPath;
    }

    /**
     * 通过分贝提升音量
     *
     * @param audioPath 音频地址
     * @param outputDir 输出目录
     * @param decibel   分贝音量
     * @return 音频地址
     * @throws Exception 异常
     */
    @SuppressWarnings("all")
    public static String raiseByDecibel(String audioPath, String outputDir, int decibel) throws Exception {
        List<String> paths = Splitter.on(".").splitToList(audioPath);
        String ext = paths.get(paths.size() - 1);
        if (!Arrays.asList("wav", "mp3").contains(ext)) {
            throw new Exception("format error");
        }
        String resultPath = Joiner.on(File.separator).join(Arrays.asList(outputDir, IdUtil.simpleUUID() + "." + ext));
        String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);
        ProcessBuilder builder =
                new ProcessBuilder(
                        ffmpeg,
                        "-i",
                        audioPath,
                        "-filter:a",
                        MessageFormat.format("volume={0}dB", String.valueOf(decibel)),
                        resultPath);
        builder.inheritIO().start().waitFor();
        return resultPath;
    }

}
