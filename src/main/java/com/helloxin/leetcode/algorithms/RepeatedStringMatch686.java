package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/21.
 */
public class RepeatedStringMatch686 {

    public int repeatedStringMatch(String A, String B) {

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) {
            return count;
        }
        if(sb.append(A).toString().contains(B)) {
            return ++count;
        }
        return -1;
    }
}
