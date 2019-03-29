package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/29.
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase709 {

    public String toLowerCase(String str) {
        String newstr="";
        for (int i=0; i<str.length();i++){
            char c=str.charAt(i);
            if (c>=65 && c<=90){
                c+=32;
            }
            newstr+=c;
        }
        return newstr;
    }

    public String toLowerCase2(String str) {
        char[] charArray = str.toCharArray();
        int diff = 'A' - 'a';
        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(c >= 'A' && c <= 'Z') {
                charArray[i] = (char)(c - diff);
            }
        }
        return new String(charArray);
    }

    public String toLowerCase3(String str) {
        return str.toLowerCase();

    }
}
