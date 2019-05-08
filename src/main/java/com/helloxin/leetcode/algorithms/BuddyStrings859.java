package com.helloxin.leetcode.algorithms;

import java.util.*;

/**
 * Created by nandiexin on 2019/5/8.
 */
public class BuddyStrings859 {

    public static boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) {
            return false;
        }
        Set<Character> set = new HashSet();
        if (A.equals(B)) {
            for (int i = 0; i < A.length(); i++) {
                if (!set.add(A.charAt(i))) {
                    return true;
                }
            }
        }
        int first = -1;
        int second = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                }
            }
        }
        if (first == -1 || second == -1) {
            return false;
        }
        Character fc = A.charAt(first);
        Character sc = A.charAt(second);
        StringBuilder aa = new StringBuilder(A);
        aa.setCharAt(first, sc);
        aa.setCharAt(second, fc);
        if (aa.toString().equals(B)) {
            return true;
        }
        return false;


    }

    public boolean buddyStrings2(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) {
                s.add(c);
            }
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                dif.add(i);
            }
        }
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }


    public static void main(String[] args) {

        System.out.println(buddyStrings("aa", "aa"));

    }


}
