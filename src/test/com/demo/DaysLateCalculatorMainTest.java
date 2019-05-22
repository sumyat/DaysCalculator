package com.demo;

import com.demo.utils.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class DaysLateCalculatorMainTest {

    @Test
    public void shouldBeSuccessful() throws FileNotFoundException {
        String fileName = "success-test.txt";
        File file = FileUtils.getFileFromResources(fileName);

        String actual = DaysLateCalculatorMain.readFile(file);
        String expected = "\n" +
                " 8 1 1995, 24 12 2005, 4003\n" +
                " 12 9 1945, 15 4 1969, 8616\n" +
                " 21 5 2010, 22 5 2010, 1";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldBeFail() throws FileNotFoundException {
        String fileName = "fail-test.txt";
        File file = FileUtils.getFileFromResources(fileName);

        assertThatThrownBy(() -> {
            DaysLateCalculatorMain.readFile(file);
        }).isInstanceOf(InputMismatchException.class)
                .hasMessageContaining("Invalid format in line : 08 01 1995,24 12 2005");
    }
}