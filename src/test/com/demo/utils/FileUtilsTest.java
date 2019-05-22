package com.demo.utils;

import org.junit.Test;

import java.io.FileNotFoundException;

public class FileUtilsTest {

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowFileNotFoundException() throws FileNotFoundException {
        FileUtils.getFileFromResources("abc.txt");
    }

    @Test
    public void shouldReadFileSuccessfully() throws FileNotFoundException {
        FileUtils.getFileFromResources("success-test.txt");
    }

}