package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/11/23.

 Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

 Example 1:

 Input: 11
 Output: 3
 Explanation: Integer 11 has binary representation 00000000000000000000000000001011
 Example 2:

 Input: 128
 Output: 1
 Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 */
public class NumberOf1Bits191 {

    public static int hammingWeight(int n) {
         return Integer.bitCount(n);
    }

    //在java中不能定义unsign int 用long类型代替 测试2147483648
    public static int hammingWeight2(long n) {
        int num = 0;
        while(n > 0) {
            num += n & 1;
            n = n >>> 1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight2(  2147483648L ));
    }
}
