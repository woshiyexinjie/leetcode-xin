package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/1/24.
 *
 Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters
 Example:

 Input: "Hello, my name is John"
 Output: 5
 */
public class NumberOfSegmentsInAString434 {

    public static int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    public static int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }


    public static void main(String[] args) {


        System.out.println(countSegments2(", , , ,        a, eaefa"));

    }
}
