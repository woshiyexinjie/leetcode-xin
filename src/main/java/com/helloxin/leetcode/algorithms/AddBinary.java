package com.helloxin.leetcode.algorithms;

/*
Given two binary strings, return their sum (also a binary string).

        For example,
        a = "11"
        b = "1"
        Return "100".
*/

/**
 * create by nandiexin on 2017/12/22
 **/
public class AddBinary {

    public static String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int  n = a.length()>b.length()?a.length():b.length();


        return "";
    }

    public static void main(String[] args) {
//        System.out.println('a'-'A');
//        System.out.println('A'+32);
//        Character ch = 'a';
//        Character ch2 = new Character(ch);
//        System.out.println((char)97);

        byte[] b ={97, 98, 99};
        System.out.println(new String(b));
    }
}
