package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/5/20.
 *
 * Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i =0;
        while(i<strs.length){
            if(strs[i].startsWith(pre)){
                i++;
            }else{
               pre = pre.substring(0,pre.length()-1) ;
            }

        }
        return pre;
    }

    public static void main(String[] args) {

        String strs[]={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

    }

}
