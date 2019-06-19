package com.helloxin.leetcode.algorithms.medium;

import java.util.Stack;

/**
 * Created by nandiexin on 2019/5/20.
 *
 * Given an input string, reverse the string word by word.



 Example 1:

 Input: "the sky is blue"
 Output: "blue is sky the"
 Example 2:

 Input: "  hello world!  "
 Output: "world! hello"
 Explanation: Your reversed string should not contain leading or trailing spaces.
 Example 3:

 Input: "a good   example"
 Output: "example good a"
 Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


 Note:

 A word is defined as a sequence of non-space characters.
 Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWordsInAString151 {

    public static String reverseWords(String s) {


        String arr[] = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String aa:arr){
            if(!aa.isEmpty()) {
                stack.add(aa.trim());
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.empty()){
            builder.append(stack.pop());
            if(!stack.empty()){
                builder.append(" ");
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {

        System.out.println(reverseWords("  hello world!  "));
    }
}
