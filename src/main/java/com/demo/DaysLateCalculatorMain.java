package com.demo;

import com.demo.model.CustomDate;
import com.demo.utils.CalendarUtils;
import com.demo.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DaysLateCalculatorMain {
    //Test File which has test dates
    private static String FILENAME = "abc.txt";

    public static void main(String[] args) throws IOException {

        File file = FileUtils.getFileFromResources(FILENAME);
        String output = readFile(file);
        System.out.print(output);
    }

    public static String readFile(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        String output = "";

        //Read each line by using Scanner class
        int lineNumber = 1;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            DateParser dateParser = new DateParser(line);
            CustomDate date1 = dateParser.getDate1();
            CustomDate date2 = dateParser.getDate2();

            //Reverse dates if date2 is less than date1
            if (getNoOfDaysBy1900(date1) > getNoOfDaysBy1900(date2)) {
                CustomDate tempdate = date2;
                date2 = date1;
                date1 = tempdate;
            }

            int noOfDaysDiff = getDaysDifference(date1, date2);

            output += "\n " + printResult(date1, date2, noOfDaysDiff);

            lineNumber++;
        }
        return output;
    }

    //Calculate no of days difference from 01/01/1900
    private static int getNoOfDaysBy1900(CustomDate date2) {
        CustomDate date1 = new CustomDate(01, 01, 1900);
        return getDaysDifference(date1, date2);
    }

    private static String printResult(CustomDate date1, CustomDate date2, int noOfDaysDiff) {

        return date1.toString() + ", " + date2.toString() + ", " + noOfDaysDiff;
    }

    private static int getDaysDifference(CustomDate date1, CustomDate date2) {

        int noOfDaysDiff = date2.getDay() - date1.getDay();

        int counterYear = date1.getYear();
        int counterMonth = date1.getMonth();

        // Counter year and month of date1 until it reaches date2 year and month
        while(counterYear != date2.getYear() || counterMonth != date2.getMonth()) {
            noOfDaysDiff += CalendarUtils.getNoOfDaysByMonth(counterMonth, counterYear);
            if (counterMonth < 12) {
                counterMonth++;
            } else {
                //Reset to Jan after December
                counterMonth = 1;
                counterYear++;
            }
        }
        return noOfDaysDiff;
    }

}
