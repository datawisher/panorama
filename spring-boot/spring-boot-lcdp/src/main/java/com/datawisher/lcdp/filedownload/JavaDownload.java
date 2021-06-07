package com.datawisher.lcdp.filedownload;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author h407644
 * @date 2021-06-05
 */
public class JavaDownload {

    // 文件下载地址
    public static final String FILE_URL = "";
    // 下载后的文件
    public static final String FILE_NAME = "";


    // ------------ Java IO 下载方式 -----------------
    /**
     * 使用 BufferedInputStream 提高性能
     * 手动指定了 buffer 大小是1024， 也可以不指定大小，参考下面 fileCopy 方法
     */
    public void write() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // handle exception
        }
    }

    /**
     * java 7 提供的 Files 类的 copy 方法
     * @throws IOException
     */
    public void fileCopy() throws IOException {
        InputStream in = new URL(FILE_URL).openStream();
        Files.copy(in, Paths.get(FILE_NAME), StandardCopyOption.REPLACE_EXISTING);
    }

    // ------------- NIO下载方式 -----------------

}
