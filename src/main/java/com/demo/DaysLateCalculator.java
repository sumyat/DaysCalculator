package com.demo;

import com.demo.model.CustomDate;
import com.demo.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DaysLateCalculator {
    //File (resources/input.txt) which has test dates
    private static String FILENAME = "input.txt";

    //Date format = DD MM YYYY
    private static String dateFormat = "((0|1|2)\\d{1}) ((0|1)\\d{1}) ((19|20)\\d{2})";
    //Input format = DD MM YYYY, DD MM YYYY
    private static String inputFormat = dateFormat.concat("(,{1}) ").concat(dateFormat) ;

    public static void main(String[] args) throws IOException {

        File file = FileUtils.getFileFromResources(FILENAME);
        readFile(file);
    }

    private static void readFile(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);

        //Read each line by using Scanner class
        int lineNumber = 1;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            //Parse into matcher group by the given input format
            Matcher matcher = parseInput(line);
            if(matcher.find()) {
                //Convert into dates
                CustomDate date1 = new CustomDate(parseInt(matcher.group(1)), parseInt(matcher.group(3)), parseInt(matcher.group(5)));
                CustomDate date2 = new CustomDate(parseInt(matcher.group(8)), parseInt(matcher.group(10)), parseInt(matcher.group(12)));

                if (getNoOfDaysBy1900(date1) > getNoOfDaysBy1900(date2)) {
                    CustomDate tempdate = date2;
                    date2 = date1;
                    date1 = tempdate;
                }

                System.out.println(date1.toString() + ", " + date2.toString() + ", " + getDateDifference(date1, date2));

            } else {
                throw new InputMismatchException("Invalid format in either date or input file!");
            }

            lineNumber++;
        }
    }

    private static int getNoOfDaysBy1900(CustomDate date2) {
        CustomDate date1 = new CustomDate(01, 01, 1900);
        return getDateDifference(date1, date2);
    }

    private static int getDateDifference(CustomDate date1, CustomDate date2) {

        int noOfDaysDiff = date2.getDay() - date1.getDay();

        int counterYear = date1.getYear();
        int counterMonth = date1.getMonth();

        while(counterYear != date2.getYear() || counterMonth != date2.getMonth()) {
            noOfDaysDiff += getNoOfDaysByMonth(counterMonth, counterYear);
            if (counterMonth < 12) {
                counterMonth++;
            } else {
                //Reset after December
                counterMonth = 0;
                counterYear++;
            }
        }
        return noOfDaysDiff;
    }

    private static Matcher parseInput(String input) {
        return Pattern.compile(inputFormat).matcher(input);
    }

    public static int getNoOfDaysByMonth(int month, int year) {
        int noOfDaysInAMonth = 0;
        switch (month) {
            case 1:
                noOfDaysInAMonth = 31;
                break;
            case 2:
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
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
                throw new IncorrectMonthException("Incorrect Month!");
        }
        return noOfDaysInAMonth;
    }

}
