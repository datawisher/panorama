package com.datawisher.bee.system.word;

import com.deepoove.poi.XWPFTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author h407644
 * @date 2022-11-19
 */
public class WordMain {

    public static void main(String[] args) {
        XWPFTemplate template = XWPFTemplate.compile("template.docx").render(
                new HashMap<String, Object>(){{
                    put("title", "Hi, poi-tl Word模板引擎");
                }});
        try {
            template.writeAndClose(new FileOutputStream("output.docx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
