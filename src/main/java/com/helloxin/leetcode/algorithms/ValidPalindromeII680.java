package com.helloxin.leetcode.algorithms;


/**
 * Created by nandiexin on 2019/3/20.
 * <p>
 * <p>
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII680 {

    public static boolean validPalindrome(String s) {

        if(null == s || s.isEmpty()){
            return true;
        }
        return preFix(s);
    }

    public static boolean preFix(String s){
        boolean change = false;
        for(int i =0,j=s.length()-1;i<s.length()/2;){
            if(s.charAt(i) != s.charAt(j)){
                if(change == true){
                    return false;
                }
                i++;
                change = true;
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean tailFix(String s){
        boolean change = false;
        for(int i =0,j=s.length()-1;i<s.length()/2;){
            if(s.charAt(i) != s.charAt(j)){
                if(change == true){
                    return false;
                }
                j--;
                change = true;
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                int i1 = i, j1 = j - 1, i2 = i + 1, j2 = j;
                while (i1 < j1 && s.charAt(i1) == s.charAt(j1)) {i1++; j1--;};
                while (i2 < j2 && s.charAt(i2) == s.charAt(j2)) {i2++; j2--;};
                return i1 >= j1 || i2 >= j2;
            }
        }
        return true;
    }

    public boolean validPalindrome3(String s) {
        int l = -1, r = s.length();
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
            }
        }
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("eddboebddcaacddkbebdde"));
    }
}
