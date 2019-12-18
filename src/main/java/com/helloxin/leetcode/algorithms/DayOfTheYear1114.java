package com.helloxin.leetcode.algorithms;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by yebanxian on 2019/12/18.
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: date = "2019-01-09"
 * Output: 9
 * Explanation: Given date is the 9th day of the year in 2019.
 * Example 2:
 * <p>
 * Input: date = "2019-02-10"
 * Output: 41
 * Example 3:
 * <p>
 * Input: date = "2003-03-01"
 * Output: 60
 * Example 4:
 * <p>
 * Input: date = "2004-03-01"
 * Output: 61
 */
public class DayOfTheYear1114 {
    public int dayOfYear(String S) {
        String[] s = S.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int date = Integer.parseInt(s[2]);
        boolean isLeap = checkYear(year);
        int noOfDays = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            if (isLeap && i == 1) {
                noOfDays += days[i] + 1;
                continue;
            }
            noOfDays += days[i];
        }
        return noOfDays + date;
    }

    boolean checkYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public int dayOfYear2(String date) {
        Calendar cld = Calendar.getInstance();
        int[] time = Arrays.stream(date.split("-")).mapToInt(t -> Integer.parseInt(t)).toArray();
        cld.set(time[0], time[1] - 1, time[2]);
        return cld.get(Calendar.DAY_OF_YEAR);
    }
}
