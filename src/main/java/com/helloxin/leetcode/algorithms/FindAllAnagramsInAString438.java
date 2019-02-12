package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2019/2/12.
 *
 *Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class FindAllAnagramsInAString438 {


    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }
        for(int i = 0;i<=(s.length()-p.length());i++){
            if(isAnagram(i,s,p)){
                list.add(i);
            }
        }

        return list;

    }


    private static boolean isAnagram(int begin, String s, String p) {
        //这样子还是不能去重
//        List<Integer> list = new ArrayList<>();
//        for(int j= 0;j<p.length();j++){
//           if(!p.contains(s.charAt(j+i)+"") || list.contains(p.indexOf(s.charAt(j+i)+""))){
//               return false;
//           }
//           list.add(p.indexOf(s.charAt(j+i)+""));
//        }
//        return true;

        int[] alphabet = new int[26];
        for (int i = 0; i < p.length(); i++) {
            alphabet[s.charAt(i+begin) - 'a']++;
        }
        for (int k = 0; k < p.length(); k++) {
            alphabet[p.charAt(k) - 'a']--;
        }
        for (int j : alphabet) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        System.out.println(findAnagrams("baa","aa"));
//        System.out.println(findAnagrams("abab","ab"));

    }
}
