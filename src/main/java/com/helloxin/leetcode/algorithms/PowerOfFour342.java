package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/12/18.
 *
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example 1:

 Input: 16
 Output: true
 Example 2:

 Input: 5
 Output: false
 Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour342 {

    public static boolean isPowerOfFour(int num) {

        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;

    }

    //前面是是否是2的幂  后面是能被3整除 ，这暂时理解不了
    public static boolean isPowerOfFour2(int num) {

        return (num&(num-1))==0 && num>0 && (num-1)%3==0;

    }

    public static void main(String[] args) {

        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(12));


        System.out.println(8&0x55555555);
        System.out.println(Integer.toBinaryString(1431655765));


    }


}
