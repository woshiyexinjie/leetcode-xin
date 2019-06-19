package com.helloxin.leetcode.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nandiexin on 2019/5/20.
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {

            for(int j = i;j<n;j++){

                char ta = s.charAt(j);
                if(!set.contains(ta)){
                    set.add(ta);
                }else{
                    if(max < set.size()){
                        max = set.size();
                    }
                    set.clear();
                    break;
                }
            }

        }
        return max;

    }

    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));

            } else {
                set.remove(s.charAt(i++));
            }
            max = Math.max(max, set.size());
        }

        return max;
    }

    public static void main(String[] args) {


        LongestSubstringWithoutRepeatingCharacters3 al = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(al.lengthOfLongestSubstring("bbbbb"));



    }

}
