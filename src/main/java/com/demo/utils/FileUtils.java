package com.demo.utils;

import java.io.File;
import java.net.URL;
import java.util.InputMismatchException;

public class FileUtils {

    // Get file from the class path resources
    public static File getFileFromResources(String fileName) {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new InputMismatchException("File is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
