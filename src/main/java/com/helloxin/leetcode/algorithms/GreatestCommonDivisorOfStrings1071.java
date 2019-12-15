package com.helloxin.leetcode.algorithms;

/**
 * Created by yebanxian on 2019/12/15.
 * or strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 * <p>
 * Return the largest string X such that X divides str1 and X divides str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */
public class GreatestCommonDivisorOfStrings1071 {
    public static String gcdOfStrings(String s1, String s2) {
        if(s1.length()<s2.length()) {
            return gcdOfStrings(s2, s1);
        }
        if(s2.length() == 0) {
            return s1;
        }
        if(s1.startsWith(s2)){
            while(s1.startsWith(s2)){
                s1 = s1.substring(s2.length());
            }
            return gcdOfStrings(s2, s1);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABAB","ABAB"));
    }
}
