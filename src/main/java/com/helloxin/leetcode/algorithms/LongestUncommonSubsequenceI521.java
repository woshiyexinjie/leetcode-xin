package com.helloxin.leetcode.algorithms;

import javax.crypto.Mac;

/**
 * Created by nandiexin on 2019/3/3.
 * 给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * <p>
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * <p>
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 * <p>
 * 示例 :
 * <p>
 * 输入: "aba", "cdc"
 * 输出: 3
 * 解析: 最长特殊序列可为 "aba" (或 "cdc")
 * 说明:
 * <p>
 * 两个字符串长度均小于100。
 * 字符串中的字符仅含有 'a'~'z'。
 * <p>
 * "aefawfawfawfaw"
 * "aefawfeawfwafwaef"
 */
public class LongestUncommonSubsequenceI521 {


    public static int findLUSlength(String a, String b) {

        int maxLength = -1;
        String lengthStr = a.length() > b.length() ? a : b;
        String shortStr = a.length() > b.length() ? b : a;
        for (int i = 0; i < lengthStr.length(); i++) {

            for (int j = i; j <= lengthStr.length(); j++) {
                String subStr = lengthStr.substring(i, j);
                if (!shortStr.contains(subStr)) {
                    if (maxLength < subStr.length()) {
                        maxLength = subStr.length();
                    }
                }
            }

        }
        return maxLength;
    }

    //原来题目的意思是这个
    public int findLUSlength2(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        System.out.println(findLUSlength("aefawfawfawfaw", "aefawfeawfwafwaef"));
    }
}
