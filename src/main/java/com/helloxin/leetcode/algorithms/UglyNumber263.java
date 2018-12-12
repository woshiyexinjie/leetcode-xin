package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/12/12.
 *
 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

 Example 1:

 Input: 6
 Output: true
 Explanation: 6 = 2 × 3
 Example 2:

 Input: 8
 Output: true
 Explanation: 8 = 2 × 2 × 2
 Example 3:

 Input: 14
 Output: false
 Explanation: 14 is not ugly since it includes another prime factor 7.
 */
public class UglyNumber263 {

    //用除法和取余
    public static boolean isUgly(int num) {

        boolean result = false;

        while(num >= 1) {
            boolean change = false;
            if (num % 2 == 0) {
                num /= 2;
                change = true;
            }
            if (num % 3 == 0) {
                num /= 3;
                change = true;
            }
            if (num % 5 == 0) {
                num /= 5;
                change = true;
            }
            if(num ==1){
                result = true;
                break;
            }
            if(!change){
                break;
            }
        }

        return result;
    }

    //换个方式
    public static boolean isUgly2(int num) {
        if(num==1) {
            return true;
        }
        if(num==0) {
            return false;
        }
        while(num%2==0) {
            num=num>>1;
        }
        while(num%3==0) {
            num=num/3;
        }
        while(num%5==0) {
            num=num/5;
        }
        return num==1;
    }

    public static void main(String[] args) {

        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));


    }



}
