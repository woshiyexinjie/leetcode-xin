package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/14.
 * <p>
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII557 {


    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            StringBuffer temp = new StringBuffer(str);
            sb.append(temp.reverse());
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
