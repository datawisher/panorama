package com.datawisher.spring.boot.file;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description Converting a Spring MultipartFile to a File
 */
public class MultipartFileToFileTest {

    @Test
    public void testGetBytes() throws Exception {
        MultipartFile multipartFile = new MockMultipartFile("sourceFile.tmp", "Hello World".getBytes());

        File file = new File("src/test/resources/targetFile.tmp");

        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        }

        assertThat(FileUtils.readFileToString(new File("src/test/resources/targetFile.tmp"), "UTF-8"))
                .isEqualTo("Hello World");
    }

    @Test
    public void testGetInputStream() throws Exception {
        MultipartFile multipartFile = new MockMultipartFile("sourceFile.tmp", "Hello World".getBytes());

        InputStream initialStream = multipartFile.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File targetFile = new File("src/test/resources/targetFile.tmp");

        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(buffer);
        }

        assertThat(FileUtils.readFileToString(new File("src/test/resources/targetFile.tmp"), "UTF-8"))
                .isEqualTo("Hello World");
    }

    @Test
    public void testTransferTo() throws Exception {
        MultipartFile multipartFile = new MockMultipartFile("sourceFile.tmp", "Hello World".getBytes());

        File file = new File("src/test/resources/targetFile.tmp");

        multipartFile.transferTo(file);

        assertThat(FileUtils.readFileToString(new File("src/test/resources/targetFile.tmp"), "UTF-8"))
                .isEqualTo("Hello World");

    }
}
