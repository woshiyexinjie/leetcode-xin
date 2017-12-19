package com.helloxin.leetcode.algorithms;

/**
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1

 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by nandiexin on 2017/12/19
 **/
public class Implement_strStr {

    /**
     * 假如使用 string 的函数
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
           return haystack.indexOf(needle) ;
    }

    /**
     * 用两个for循环 去解决问题  如果字符串长了  要匹配多久呢？
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {

        int m = haystack.length(), n = needle.length();
        if (m < n) {
            return -1;
        }
        for (int i = 0; i <= m - n; ++i) {
            int j = 0;
            for (j = 0; j < n; ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 然后就可以用正则表达式啦  当然正则这个包在leetcode是通不过的哈
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr3(String haystack, String needle){
        Pattern p = Pattern.compile(needle);
        Matcher m = p.matcher(haystack);

        while(m.find()) {
           return m.start();
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(strStr3("hello","lp"));
    }
}
