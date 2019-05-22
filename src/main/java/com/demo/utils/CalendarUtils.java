package com.demo.utils;

import com.demo.IncorrectMonthException;

public class CalendarUtils {
    public static int getNoOfDaysByMonth(int month, int year) {
        int noOfDaysInAMonth = 0;
        switch (month) {
            case 1:
                noOfDaysInAMonth = 31;
                break;
            case 2:
                if (isLeapYear(year)) {
                    noOfDaysInAMonth = 29;
                } else {
                    noOfDaysInAMonth = 28;
                }
                break;
            case 3:
                noOfDaysInAMonth = 31;
                break;
            case 4:
                noOfDaysInAMonth = 30;
                break;
            case 5:
                noOfDaysInAMonth = 31;
                break;
            case 6:
                noOfDaysInAMonth = 30;
                break;
            case 7:
                noOfDaysInAMonth = 31;
                break;
            case 8:
                noOfDaysInAMonth = 31;
                break;
            case 9:
                noOfDaysInAMonth = 30;
                break;
            case 10:
                noOfDaysInAMonth = 31;
                break;
            case 11:
                noOfDaysInAMonth = 30;
                break;
            case 12:
                noOfDaysInAMonth = 31;
                break;
            default:
                throw new IncorrectMonthException("Invalid Month!");
        }
        return noOfDaysInAMonth;
    }

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
}
