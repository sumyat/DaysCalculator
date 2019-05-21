package com.demo.model;

/**
 * Represent a date with property day, month, year.
 * Day could be from 1 to 31.
 * Month could be from 1 to 12.
 * Year is between 1900 and 2010.
 */
public class CustomDate {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public CustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return day + " " + month + " "+ year;
     }
}
