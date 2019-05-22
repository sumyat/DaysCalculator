package com.demo;

import com.demo.model.CustomDate;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;

public class DateParserTest {

    @Test
    public void shouldParseDatesSuccessfully() {
        DateParser dateParser = new DateParser("08 01 1995, 24 12 2005");
        assertThat(dateParser.getDate1()).isEqualTo(new CustomDate(8, 1, 1995));
        assertThat(dateParser.getDate2()).isEqualTo(new CustomDate(24, 12, 2005));
    }

    @Test(expected = InputMismatchException.class)
    public void shouldNotReadFileForIncorrectInputFormat() {
        DateParser dateParser = new DateParser("08 011995, 24 12 2005");
    }

    @Test(expected = InputMismatchException.class)
    public void shouldNotReadFileForIncorrectDateFormat() {
        DateParser dateParser = new DateParser("08 1995 01, 24 12 2005");
    }
}