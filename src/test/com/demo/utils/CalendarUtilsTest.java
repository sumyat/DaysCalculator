package com.demo.utils;

import com.demo.IncorrectMonthException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarUtilsTest {

    @Test
    public void shouldGetNoOfDaysByJan() {
        int expected = 31;
        int actual = CalendarUtils.getNoOfDaysByMonth(1, 1995);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldGetNoOfDaysByFebByLeapYear() {
        int expected = 29;
        int actual = CalendarUtils.getNoOfDaysByMonth(2, 1996);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldGetNoOfDaysByFebByNonLeapYear() {
        int expected = 28;
        int actual = CalendarUtils.getNoOfDaysByMonth(2, 1995);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(expected = IncorrectMonthException.class)
    public void shouldThrowsIncorrectMonthException() {
        CalendarUtils.getNoOfDaysByMonth(0, 1990);
    }

}