package com.helloxin.leetcode.algorithms;

import java.util.Map;

/**
 * Created by nandiexin on 2019/1/8.
 *
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString387 {

    public static int firstUniqChar(String s) {

        int[] arr = new int[26];
        for(int i =0;i<s.length();i++){
            arr[s.charAt(i) - 'a']++;
        }
        for(int j =0;j<s.length();j++){
            if(arr[s.charAt(j) - 'a'] == 1){
                return j;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));

    }
}
