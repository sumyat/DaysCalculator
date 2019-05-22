package com.demo;

import com.demo.model.CustomDate;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * @desc represents to convert the input String read from the file
 * into CustomDate objects
 * @param line a String text read from the input file line by line
 */
public class DateParser {
    //Date format = DD MM YYYY
    private static String dateFormat = "((0|1|2)\\d{1}) ((0|1)\\d{1}) ((19|20)\\d{2})";
    //Input format = DD MM YYYY, DD MM YYYY
    private static String inputFormat = dateFormat.concat("(,{1}) ").concat(dateFormat) ;

    private CustomDate date1;
    private CustomDate date2;

    public DateParser(String line) {
        Matcher matcher = parseInput(line);
        if (matcher.find()) {
            this.date1 = parseFirstDate(matcher);
            this.date2 = parseSecondDate(matcher);
        } else {
            throw new InputMismatchException("Invalid format in line : " + line);
        }
    }

    /**
     * @desc create CustomDate object of second date
     * according to the input file format "DD MM YYYY, DD MM YYYY".
     * Assume that file format is fixed.
     * example: 08 01 1995, 24 12 2005
     * @return object of 24 12 2005
     */
    private static CustomDate parseSecondDate(Matcher matcher) {
        int day = parseInt(matcher.group(8));
        int month = parseInt(matcher.group(10));
        int year = parseInt(matcher.group(12));
        return new CustomDate(day, month, year);
    }

    /**
     * @desc create CustomDate object of first date
     * according to the input file format "DD MM YYYY, DD MM YYYY".
     * Assume that file format is fixed.
     * example: 08 01 1995, 24 12 2005
     * @return object of 08 01 1995
     */
    private static CustomDate parseFirstDate(Matcher matcher) {
        int day = parseInt(matcher.group(1));
        int month = parseInt(matcher.group(3));
        int year = parseInt(matcher.group(5));
        return new CustomDate(day, month, year);
    }

    private static Matcher parseInput(String input) {
        return Pattern.compile(inputFormat).matcher(input);
    }

    public CustomDate getDate1() {
        return date1;
    }

    public CustomDate getDate2() {
        return date2;
    }
}
