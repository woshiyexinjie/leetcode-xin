package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by nandiexin on 2019/4/30.
 * <p>
 * <p>
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * <p>
 * <p>
 * Note:
 * <p>
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
public class ShortestDistanceToACharacter821 {

    public static int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = S.indexOf(C);
        int nextPos =(S.indexOf(C,pos+1)< 0? Integer.MAX_VALUE:S.indexOf(C,pos+1));
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C) {
                pos = i;
                nextPos =(S.indexOf(C,pos+1)< 0? Integer.MAX_VALUE:S.indexOf(C,pos+1));
            }
            res[i] =Math.min(Math.abs(i - pos),Math.abs(i - nextPos));
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(shortestToChar("loveleetcode",'e')));
    }
}
