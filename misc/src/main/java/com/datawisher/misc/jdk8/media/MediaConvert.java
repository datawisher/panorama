package com.datawisher.misc.jdk8.media;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.tika.Tika;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;

public class MediaConvert {

    /*public static void main(String[] args) throws EncoderException {
        System.out.println("testEncodeVideo");

        File source = new File("misc/src/main/resources","a.mp4");
        File target = new File("misc/src/main/resources","b.mp4");
        if (target.exists()) {
            target.delete();
        }
        AudioAttributes audioAttr = new AudioAttributes();
        VideoAttributes videoAttr = new VideoAttributes();
        EncodingAttributes encodingAttr = new EncodingAttributes();

        audioAttr.setChannels(2);
        audioAttr.setCodec("aac");
        audioAttr.setBitRate(128000);
        audioAttr.setSamplingRate(44100);

        videoAttr.setCodec("libx264");
        videoAttr.setBitRate(1000000);

        encodingAttr.setAudioAttributes(audioAttr);
        encodingAttr.setVideoAttributes(videoAttr);
        encodingAttr.setOutputFormat("mp4");

        Encoder encoder = new Encoder();
        encoder.encode(new MultimediaObject(source), target, encodingAttr);
    }*/

    public static void main(String[] args) throws IOException {
        File source = new File("misc/src/main/resources","a.mp4");
        byte[] bytes = Files.readAllBytes(Paths.get(source.getPath()));
        String detect = new Tika().detect(bytes);
        System.out.println("detect = " + detect);
    }
}
