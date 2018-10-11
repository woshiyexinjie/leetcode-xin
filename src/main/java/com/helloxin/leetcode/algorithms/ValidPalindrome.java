package com.helloxin.leetcode.algorithms;



/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */

/**
 * Created by nandiexin on 2018/10/11.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        //题目中说明空字符串也是true
        if(null == s || s.isEmpty()){
            return true;
        }
        boolean result = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i< s.length();i++){
            Character a = s.charAt(i);
            if(Character.isLetterOrDigit(a)){
                //这里如果是不用Character的方法，我们可以哥怒ASCII A 65 a 97 数据不需要处理
                stringBuilder.append(Character.toLowerCase(a));
            }
        }
        //不用String的方法，也可以将字符串倒过来
        String oldString = stringBuilder.toString();
        String reverse = stringBuilder.reverse().toString();
        //这里不用String的方法，用个for循环比较要一下
        if(oldString.equals(reverse)){
            result = true;
        }
        return result;
    }

    public boolean isPalindrome2(String s) {
        //题目中说明空字符串也是true
        if(null == s || s.isEmpty()){
            return true;
        }
        boolean result = false;
        int i = 0,j = s.length()-1;
        //然后我们从头尾开始遍历，跳过不是字母和数字的字符 如果发现不匹配的就返回false
        while(i<j){
            char a = Character.toLowerCase(s.charAt(i));
            while (!Character.isLetterOrDigit(a) && i<j){
                 i++;
                 a = Character.toLowerCase(s.charAt(i));
            }
            char b = Character.toLowerCase(s.charAt(j));
            while (!Character.isLetterOrDigit(b) && i<j) {
                j--;
                b = Character.toLowerCase(s.charAt(j));
            }
            if(a != b){
                result = false;
                return result;
            }
            i++;
            j--;

        }
        if(i >= j){
            result = true;
        }
        return result;
    }


    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String input = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome.isPalindrome2(input));
    }

}
