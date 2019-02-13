package com.helloxin.leetcode.algorithms;

import java.util.Map;

/**
 * Created by nandiexin on 2019/2/13.
 *
 *
 Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:

 Input: "abab"
 Output: True
 Explanation: It's the substring "ab" twice.
 Example 2:

 Input: "aba"
 Output: False
 Example 3:

 Input: "abcabcabcabc"
 Output: True
 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern459 {

    public static boolean repeatedSubstringPattern(String s) {

//         if(s.length() ==1 || s.length() ==0){
//             return false;
//         }
//         int chars[] = new int[26];
//         for (int i=0;i<s.length();i++){
//             chars[s.charAt(i)-'a'] ++;
//         }
//         int uquelNum = 0;
//         int count =0;
//         for (int i=0;i<chars.length;i++){
//             if(chars[i]>0 ){
//                 if(uquelNum ==0){
//                     uquelNum = chars[i];
//                 }
//                 if(uquelNum != chars[i]){
//                     return false;
//                 }
//                 count++;
//             }
//         }
//         String repeateStr = s.substring(0,count);
//         String test = new String(s);
//         while(test.startsWith(repeateStr)){
//             test=test.replace(repeateStr,"");
//         }
//         if(!test.isEmpty()){
//              return false;
//         }
//         return true;
        String s2 = s + s;
              return s2.substring(1, s2.length() - 1).contains(s);
    }

    public static void main(String[] args) {

//        System.out.println(repeatedSubstringPattern("abab"));
//        System.out.println(repeatedSubstringPattern("aba"));
//        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
//        System.out.println(repeatedSubstringPattern("ababba"));
        System.out.println(repeatedSubstringPattern("abaababaab"));


    }
}
