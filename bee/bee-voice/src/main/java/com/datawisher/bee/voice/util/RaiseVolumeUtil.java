package com.datawisher.bee.voice.util;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.bytedeco.javacpp.Loader;

import java.io.File;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

/**
 * 提升音量工具 @Version: V1.0
 */
public class RaiseVolumeUtil {
  /**
   * 通过倍率提升音量
   *
   * @param audioPath 音频地址
   * @param outputDir 输出目录
   * @return 文件地址
   * @throws Exception 异常
   */
  public static String raiseByRatio(String audioPath, String outputDir, float ratio)
      throws Exception {
    List<String> strings = Splitter.on("/").splitToList(audioPath);
    String fileName = strings.get(strings.size() - 1);
    List<String> fileNameAndExt = Splitter.on(".").splitToList(fileName);
    String ext = fileNameAndExt.get(fileNameAndExt.size() - 1);
    if (!Arrays.asList("wav", "mp3").contains(ext)) {
      throw new Exception("format error");
    }
    String resultPath =
        Joiner.on(File.separator).join(Arrays.asList(outputDir, fileNameAndExt.get(0) + "-amplify" + "." + ext));
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
}