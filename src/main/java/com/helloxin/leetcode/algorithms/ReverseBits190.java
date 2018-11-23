package com.helloxin.leetcode.algorithms;

import java.util.ArrayDeque;

/**
 *
 *
 Created by nandiexin on 2018/11/21.
 Reverse bits of a given 32 bits unsigned integer.

 Example:

 Input: 43261596
 Output: 964176192
 Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 return 964176192 represented in binary as 00111001011110000010100101000000.
 Follow up:
 If this function is called many times, how would you optimize it?

 */
public class ReverseBits190 {

    public static int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31){
                result <<= 1;
            }
        }
        return result;

    }

    public  static int reverseBits2(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args) {

        System.out.println(reverseBits2(-1));
        System.out.println(reverseBits(-1));

        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.addFirst(1);
        test.addFirst(2);
        test.size();

        System.out.println((0-14)&15);

    }
}
