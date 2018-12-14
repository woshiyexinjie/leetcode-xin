package com.helloxin.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nandiexin on 2018/12/14.
 *
 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Example 1:

 Input: pattern = "abba", str = "dog cat cat dog"
 Output: true
 Example 2:

 Input:pattern = "abba", str = "dog cat cat fish"
 Output: false
 Example 3:

 Input: pattern = "aaaa", str = "dog cat cat dog"
 Output: false
 Example 4:

 Input: pattern = "abba", str = "dog dog dog dog"
 Output: false
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern290 {

    //对于匹配的问题 感觉一般用map都是可以的
    public static boolean wordPattern(String pattern, String str) {
        boolean result = true;
        Map<Character, String> map = new HashMap<>();
        String arrays[] = str.split(" ");
        if(arrays.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                String value = map.get(pattern.charAt(i));
                if (!value.equals(arrays[i])) {
                    result = false;
                    break;
                }
            } else {
                if(map.containsValue(arrays[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), arrays[i]);

            }

        }

        return result;
    }

    //化简一下 直接通过put操作判断 简化了contains操作
    public static boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i) {
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(wordPattern( "abba", "dog dog dog dog"));
    }
}
