package com.demo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class FileUtils {

    // Get file from the class path resources
    public static File getFileFromResources(String fileName) throws FileNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new FileNotFoundException("File is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
