package com.helloxin.leetcode.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yebanxian on 2021/2/12.
 */
public class LongestPalindromicSubstring5 {

    private static boolean judgePalindromicString(String test) {
//        if (null == test || test.length() == 0) {
//            return false;
//        }
//        StringBuilder sb = new StringBuilder(test);
//        if (sb.reverse().toString().equals(test)) {
//            return true;
//        }
//        return false;
        int length = test.length();
        for (int i = 0; i < length / 2; i++) {
            if (test.toCharArray()[i] != test.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        //循环遍历  这种方法就是会超时
        if (s.length() == 1) {
            return s;
        }
        List<String> liststr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                liststr.add(s.substring(i, j));
            }
        }
        String tmpLongest = "";
        if (!liststr.isEmpty()) {
            for (int i = 0; i < liststr.size(); i++) {
                if(liststr.get(i).length() <= tmpLongest.length()){
                    continue;
                }
                if (judgePalindromicString(liststr.get(i)) && liststr.get(i).length() > tmpLongest.length()) {
                    tmpLongest = liststr.get(i);
                }
            }
        }
        return tmpLongest;
    }

    public static String longestPalindrome2(String s) {
        //循环遍历优化一下  这种方法就是会超时
        if (s.length() == 1) {
            return s;
        }
        String tmpLongest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String test = s.substring(i, j);
                if(test.length() <= tmpLongest.length()){
                    continue;
                }
                if (judgePalindromicString(test) && test.length() > tmpLongest.length()) {
                    tmpLongest = test;
                }
            }
        }
        return tmpLongest;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

}
