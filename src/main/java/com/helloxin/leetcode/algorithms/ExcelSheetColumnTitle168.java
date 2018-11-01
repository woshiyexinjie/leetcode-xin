package com.helloxin.leetcode.algorithms;


/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
*/

/**
 * Created by nandiexin on 2018/10/26.
 */
public class ExcelSheetColumnTitle168 {

    public static String convertToTitle(int n) {

        StringBuilder result= new StringBuilder();

        while (n > 0 ) {
            int merchant = n / 26;
            int remainder = n % 26;

            if(remainder==0) {
                result = result.append((char) ('Z'));
                merchant--;
            } else {
               result = result.append((char)('A'-1+remainder));
            }
            n = merchant;
        }
        return result.reverse().toString();

    }

    public static void main(String[] args) {

        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(701));

    }

}
