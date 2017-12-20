package com.helloxin.leetcode.algorithms;


/*
        Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
        return the length of last word in the string.

        If the last word does not exist, return 0.

        Note: A word is defined as a character sequence consists of non-space characters only.

        Example:

        Input: "Hello World"
        Output: 5
*/

/**
 * create by nandiexin on 2017/12/20
 **/
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

    public static int lengthOfLastWord2(String s) {
        String[] array = s.trim().split(" ");

        return array[array.length-1].length();
    }

    public static int lengthOfLastWord3(String s) {
        String temp = s.trim();
        int split = temp.lastIndexOf(" ");
        if(split <= -1){
            return temp.length();
        }
        return temp.length() - split -1;
    }

    public static int lengthOfLastWord4(String s) {
        String temp = s.trim();
        if(temp.isEmpty()){
            return 0;
        }
        int split = 0;
        for (int i= 0;i<temp.length();i++){
            if(temp.charAt(i) == ' '){
                split = i;
            }
        }
        if(split == 0){
            return temp.length();
        }
        return temp.length() - split -1;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLastWord4("hello world"));

    }
}
