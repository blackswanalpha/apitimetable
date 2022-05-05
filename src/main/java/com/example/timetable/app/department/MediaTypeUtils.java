package com.example.timetable.app.department;

import javax.servlet.ServletContext;

import org.springframework.http.MediaType;

public class MediaTypeUtils {

    // abc.zip
    // abc.pdf,..
    public static MediaType getMediaTypeForFileName(ServletContext servletContext, String fileName) {
        // application/pdf
        // application/xml
        // image/gif, ...
        String mineType = servletContext.getMimeType(fileName);
        try {
            MediaType mediaType = MediaType.parseMediaType(mineType);
            return mediaType;
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

}
