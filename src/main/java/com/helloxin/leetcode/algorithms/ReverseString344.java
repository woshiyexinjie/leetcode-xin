package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/12/21.
 *
 Write a function that takes a string as input and returns the string reversed.

 Example 1:

 Input: "hello"
 Output: "olleh"
 Example 2:

 Input: "A man, a plan, a canal: Panama"
 Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseString344 {

    //这个之前已经洗了很多方法了 这里就写一个吧
    public String reverseString(String s) {

        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }

    public String reverseString2(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public String reverseString3(String s) {
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            byte temp = bytes[i];
            bytes[i] = bytes[j];
            bytes[j] = temp;
            i++;
            j--;
        }
        return new String(bytes);
    }

    public String reverseString4(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            word[i] = (char) (word[i] ^ word[j]);
            word[j] = (char) (word[i] ^ word[j]);
            word[i] = (char) (word[i] ^ word[j]);
            i++;
            j--;
        }
        return new String(word);
    }

    public String reverseString5(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
