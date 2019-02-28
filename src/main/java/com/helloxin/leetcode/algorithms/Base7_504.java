package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/2/22.
 Given an integer, return its base 7 string representation.

 Example 1:
 Input: 100
 Output: "202"
 Example 2:
 Input: -7
 Output: "-10"
 Note: The input will be in range of [-1e7, 1e7].
 */
public class Base7_504 {

    public String convertTo7(int num) {

        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        boolean negative = false;

        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }

        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }


}
