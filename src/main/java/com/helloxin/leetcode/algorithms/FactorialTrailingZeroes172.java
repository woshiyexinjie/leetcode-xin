package com.helloxin.leetcode.algorithms;

import java.math.BigDecimal;

/**
 * Created by nandiexin on 2018/11/13.
 *
Given an integer n, return the number of trailing zeroes in n!.

 Example 1:

 Input: 3
 Output: 0
 Explanation: 3! = 6, no trailing zero.
 Example 2:

 Input: 5
 Output: 1
 Explanation: 5! = 120, one trailing zero.
 */
public class FactorialTrailingZeroes172 {


    public static int trailingZeroes(int n) {

        int num = 0;
        int num5 = 0;
        for (int i=1;i<=n;i++){
            int nu = i;
            while(nu%5==0 && nu >0){
                num5++;
                nu = nu/5;
            }
        }
        return num5;
    }


    public static int trailingZeroes2(int n) {
        int count = 0;
        while(n > 1){
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes2(3));

        System.out.println(trailingZeroes(6));
        System.out.println(trailingZeroes2(6));

        System.out.println(trailingZeroes(10));
        System.out.println(trailingZeroes2(10));

        System.out.println(trailingZeroes(25));
        System.out.println(trailingZeroes2(25));

        System.out.println(trailingZeroes(31));
        System.out.println(trailingZeroes2(31));

        System.out.println(trailingZeroes(66));
        System.out.println(trailingZeroes2(66));

    }

}
