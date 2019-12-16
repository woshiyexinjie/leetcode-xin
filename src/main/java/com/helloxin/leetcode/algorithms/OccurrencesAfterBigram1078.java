package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yebanxian on 2019/12/15.
 * Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
 * <p>
 * For each such occurrence, add "third" to the answer, and return the answer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 * Example 2:
 * <p>
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= text.length <= 1000
 * text consists of space separated words, where each word consists of lowercase English letters.
 * 1 <= first.length, second.length <= 10
 * first and second consist of lowercase English letters.
 */
public class OccurrencesAfterBigram1078 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < words.length; ++i) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1])) {
                ans.add(words[i]);
            }
        }
        return ans.toArray(new String[0]);
    }

    public String[] findOcurrences2(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i >= 0) {
            String two = first + ' ' + second + ' ';
            int idx = text.indexOf(two, i);
            int end = idx + two.length(), start = end;
            while (end < text.length() && text.charAt(end) != ' ') {
                ++end;
            }
            if (idx >= 0 && start < text.length()) {
                ans.add(text.substring(start, end));
            } else {
                break;
            }
            i = idx + first.length() + 1;
        }
        return ans.toArray(new String[0]);
    }
}
