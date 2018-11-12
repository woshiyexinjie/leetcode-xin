package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/11/12.
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 Example 1:

 Input: "A"
 Output: 1
 Example 2:

 Input: "AB"
 Output: 28
 Example 3:

 Input: "ZY"
 Output: 701
 */
public class ExcelSheetColumnNumber171 {

    public static int titleToNumber(String s) {

        int sum = 0 ;
        int loop =1;
        for (int i = s.length()-1;i >=0;i--){
             char c = s.charAt(i);
             sum += (c-'A'+1)*loop;
             loop *= 26;
        }
        return sum;

    }

    public static void main(String[] args) {

        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));

        System.out.println(titleToNumber("ZY"));

        System.out.println(titleToNumber("ZA"));


    }


}
