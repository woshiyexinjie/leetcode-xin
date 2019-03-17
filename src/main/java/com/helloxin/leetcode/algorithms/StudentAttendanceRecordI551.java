package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/14.
 * <p>
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI551 {

    public static boolean checkRecord(String s) {

        return !s.matches(".*LLL.*|.*A.*A.*");

    }



    public static boolean checkRecord2(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL")) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }

}
