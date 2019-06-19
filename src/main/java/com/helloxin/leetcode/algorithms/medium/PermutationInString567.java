package com.helloxin.leetcode.algorithms.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by nandiexin on 2019/5/20.
 * <p>
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * <p>
 * Note:
 * <p>
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString567 {


    //简单一点就是遍历一遍
    public static boolean checkInclusion(String s1, String s2) {


        boolean result= false;
        String test = "";
        for (int i = s1.length();i<=s2.length();i++){

            test = s2.substring(i-s1.length(),i);
            if(issame(test,s1)){
                return true;
            }
        }
        return false;
    }

    private static boolean issame(String test, String s1) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i=0;i<test.length();i++){
            map.put(test.charAt(i),map.getOrDefault(test.charAt(i),0)-1);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry:entries){
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

    //原理类似的
    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) {
                return true;
            }
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(checkInclusion("ab","eidboaoo"));

    }
}
