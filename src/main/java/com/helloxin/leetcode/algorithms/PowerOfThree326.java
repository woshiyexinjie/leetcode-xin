package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2018/12/18.
 Given an integer, write a function to determine if it is a power of three.

 Example 1:

 Input: 27
 Output: true
 Example 2:

 Input: 0
 Output: false
 Example 3:

 Input: 9
 Output: true
 Example 4:

 Input: 45
 Output: false
 Follow up:
 Could you do it without using any loop / recursion?
 */
public class PowerOfThree326 {

    public static List<Long> list = null;

    static{
        list = new ArrayList<>();
        for(int i= 0;i<Integer.MAX_VALUE;i++){
            Double value = Math.pow((double)3,(double)i);
            if(value.longValue() > (long)Integer.MAX_VALUE){
                  break;
            }
            list.add(value.longValue());
        }
    }

    //发现先把数据取出来 比对一下 妥妥的  但是用了loop 哎
    public static boolean isPowerOfThree(int n) {
           return list.contains((long)n);
    }


    //看看大神的表演 原来这样就可以 而且因为3是质数
    public static boolean isPowerOfThree2(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }

    //好吧 都用上公式啦
    public static boolean isPowerOfThree3(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfThree3(9));
        System.out.println(isPowerOfThree3(27));
        System.out.println(isPowerOfThree3(0));
        System.out.println(isPowerOfThree3(45));


          Integer a = 6;
          Long b = 6L;
          System.out.println(a.equals(b));

    }


}
