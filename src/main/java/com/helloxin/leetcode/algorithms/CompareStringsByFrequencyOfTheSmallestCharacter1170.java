package com.helloxin.leetcode.algorithms;

/**
 * Created by yebanxian on 2020/2/6.
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * <p>
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 * <p>
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] fCount = new int[11];
        for (String word : words) {
            int count = getFCount(word);
            fCount[count]++;
        }
        int sum = 0;
        for (int i = 0; i < fCount.length; i++) {
            sum += fCount[i];
            fCount[i] = sum;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            int count = getFCount(queries[i]);
            res[i] = fCount[fCount.length - 1] - fCount[count];
        }
        return res;
    }

    public int getFCount(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return count[i];
            }
        }
        return 0;
    }
}
