package com.demo.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Returns false if o is an instance of CustomDate or
        * null instance type*/
        if (!(o instanceof CustomDate)) {
            return false;
        }

        // typecast CustomDate
        CustomDate c = (CustomDate) o;

        return Objects.equals(day, c.getDay()) &&
                Objects.equals(month, c.getMonth()) &&
                 Objects.equals(year, c.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    public String toString() {
        return day + " " + month + " "+ year;
     }
}
