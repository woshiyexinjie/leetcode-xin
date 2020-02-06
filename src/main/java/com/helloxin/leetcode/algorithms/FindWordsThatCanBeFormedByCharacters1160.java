package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by yebanxian on 2020/2/4.
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 * <p>
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 */
public class FindWordsThatCanBeFormedByCharacters1160 {

    //这种题目 words 就是消费者，已经有的 chars 是资源，需要被消费的
    //就是一种匹配的逻辑，目前的资源能否满足
    public static int countCharacters(String[] words, String chars) {
            int count = 0;
            int[] seen = new int[26];
            //Count char of Chars String
            for (char c : chars.toCharArray()) {
                seen[c - 'a']++;
            }
            // Comparing each word in words
            for (String word : words) {
                // simple making copy of seen arr
                int[] tSeen = Arrays.copyOf(seen, seen.length);
                int Tcount = 0;
                for (char c : word.toCharArray()) {
                    if (tSeen[c - 'a'] > 0) {
                        tSeen[c - 'a']--;
                        Tcount++;
                    }
                }
                if (Tcount == word.length()) {
                    count += Tcount;
                }
            }
        return count;
    }


}
