package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2018/12/7.
 Given an integer, write a function to determine if it is a power of two.

 Example 1:

 Input: 1
 Output: true
 Explanation: 20 = 1
 Example 2:

 Input: 16
 Output: true
 Explanation: 24 = 16
 Example 3:

 Input: 218
 Output: false
 */
public class PowerOfTwo231 {

    public static List<Long> list = new ArrayList<>();

    static {
        for(int i= 0;i<32;i++){
            list.add((long) Math.pow(2D,i));
        }
    }

    public static boolean isPowerOfTwo(int n) {
          if(list.contains(Long.valueOf(n))){
              return true;
          }
          return  false;
    }

    //在二进制中 2的乘方只会存在一个1
    public static boolean  isPowerOfTwo3(int n) {

        return n>0 && Integer.bitCount(n) == 1;
    }

    //这是大神写的 没办法
    public static boolean  isPowerOfTwo2(int n) {
        if(n<=0) {
            return false;
        }
        return (n&(n-1)) <= 0 ;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo2(1));
        System.out.println(isPowerOfTwo2(16));
        System.out.println(isPowerOfTwo2(218));
        System.out.println(isPowerOfTwo2(2147483647));


        System.out.println( (int)Math.pow(2D,31));
        System.out.println( (long) Math.pow(2D,31));

    }

}
