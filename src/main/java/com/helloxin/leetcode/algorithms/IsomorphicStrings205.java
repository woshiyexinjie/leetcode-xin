package com.helloxin.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nandiexin on 2018/11/28.
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 Example 1:

 Input: s = "egg", t = "add"
 Output: true
 Example 2:

 Input: s = "foo", t = "bar"
 Output: false
 Example 3:

 Input: s = "paper", t = "title"
 Output: true
 */
public class IsomorphicStrings205 {

    // 这里我维护两个 map来处理映射，因为要求一个元素只能对一种元素
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map =  new HashMap<>();
        Map<Character,Character> map2 =  new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0;i< s.length();i++){
            Character c = s.charAt(i);
            Character c2 = t.charAt(i);
            if(map.containsKey(c)){
                 if(!c2.equals(map.get(c))){
                     return false;
                 }
            }else{
                map.put(c,c2);
            }
        }
        for(int i = 0;i< t.length();i++){
            Character c = t.charAt(i);
            Character c2 = s.charAt(i);
            if(map2.containsKey(c)){
                if(!c2.equals(map2.get(c))){
                    return false;
                }
            }else{
                map2.put(c,c2);
            }
        }
        return true;
    }

    //在相应位置维护一个值
    public static boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) {
                return false;
            }
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }

    //利用了 map的put特性 @return previous value, or null if none
    public static boolean isIsomorphic3(String s, String t) {
        Map m = new HashMap();
        for (Integer i=0; i<s.length(); ++i) {
            if (m.put(s.charAt(i), i) != m.put(t.charAt(i)+"", i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

//        System.out.println(isIsomorphic3("ab","aa"));
        System.out.println(isIsomorphic3("foo","bar"));
//        System.out.println(isIsomorphic3("paper","title"));

    }
}
