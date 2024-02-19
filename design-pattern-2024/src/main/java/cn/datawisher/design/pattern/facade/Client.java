package cn.datawisher.design.pattern.facade;

import java.io.File;

import cn.datawisher.design.pattern.facade.facade.VideoConversionFacade;

public class Client {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}
