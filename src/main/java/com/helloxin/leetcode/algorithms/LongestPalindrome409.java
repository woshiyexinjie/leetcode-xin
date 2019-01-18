package com.helloxin.leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by nandiexin on 2019/1/18.
 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome409 {

    //自然想到的正向思维 偶数的数量肯定可以组成回文，奇数只要获取其中的偶数个 如果可以中间还可以放一个
    public static int longestPalindrome(String s) {

        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i =0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                 Integer count = map.get(s.charAt(i));
                 count ++;
                 map.put(s.charAt(i),count);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        int jishu =0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()%2==0){
                result+=entry.getValue();
            }else{
                result = entry.getValue()+result-1;
                jishu++;
            }
        }
        if(jishu> 0){
            result++;
        }

        return result;
    }

    //这个加加减减的方式 也是可以的
    public static int longestPalindrome2(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) {
            return count*2+1;
        }
        return count*2;
    }

    //这里用整型数量的特性 除以2乘以2  就没有奇数偶数的问题
    public static int longestPalindrome3(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp >= 97) {
                lowercase[temp-'a']++;
            } else {
                uppercase[temp-'A']++;
            }
        }
        for (int i = 0; i < 26; i++){
            res+=(lowercase[i]/2)*2;
            res+=(uppercase[i]/2)*2;
        }
        return res == s.length() ? res : res+1;

    }

    //与上面的不同  这是获取奇数的数量
    public static int longestPalindrome4(String s) {
        int[] chars = new int[128];
        char[] t = s.toCharArray();
        for(char c:t){
            chars[c]++;
        }
        int single = 0;
        for(int n:chars){
            if(n%2!=0){
                single++;
            }
        }
        return single>1?t.length-single+1:t.length;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccccdd"));

    }

}
