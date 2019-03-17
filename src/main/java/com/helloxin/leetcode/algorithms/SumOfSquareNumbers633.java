package com.helloxin.leetcode.algorithms;

import java.util.HashSet;

/**
 * Created by nandiexin on 2019/3/17.
 * <p>
 * <p>
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output: False
 */
public class SumOfSquareNumbers633 {

    //这样渐渐靠近我们想要的数据
    public static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    //这种做法也是挺有趣的 把数据先放进去
    public boolean judgeSquareSum2(int c) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {


        System.out.println(judgeSquareSum(25));
    }
}
