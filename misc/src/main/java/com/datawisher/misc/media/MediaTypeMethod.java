package com.datawisher.misc.media;

import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class MediaTypeMethod {

    public static String[] intermediateMediaType = { "audio/amr-wb:mp3" };

    public static void main(String[] args) {
        MediaTypeMethod mediaTypeMethod = new MediaTypeMethod();
        String expectedFileType = mediaTypeMethod.getExpectedFileType("audio/amr-wb");
        System.out.println("expectedFileType = " + expectedFileType);
        String filename = StringUtils.defaultIfEmpty("abc.mp4", "abc");
        System.out.println("filename = " + filename);
    }

    public String getExpectedFileType(String mediaType) {
        if (StringUtils.isEmpty(mediaType) || ArrayUtils.isEmpty(intermediateMediaType)) {
            return null;
        }
        return Stream.of(intermediateMediaType)
                .map(kv -> kv.split(":(?=[^:]*$)")) // split by last ':'
                .filter(kv -> kv.length == 2 && mediaType.equalsIgnoreCase(kv[0]))
                .map(kv -> kv[1])
                .findFirst()
                .orElse(null);
    }

}
