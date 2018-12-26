package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2018/12/26.
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Output: true
 Example 2:

 Input: 14
 Output: false

 */
public class ValidPerfectSquare367 {

    static List<Long> list = new ArrayList<>();
    static{
        for (Long i =0L;i<Integer.MAX_VALUE;i++){
            if(i*i>Integer.MAX_VALUE){
               break;
            }
            list.add(i*i);
        }
    }

    //这样的用这种笨拙的方法一般 可以解决
    public static boolean isPerfectSquare(int num) {
        return list.contains(Long.valueOf(num));
    }

    //不知道这是怎么处理的
    public static boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    //二分查找法
    public static boolean isPerfectSquare3(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    public static boolean isPerfectSquare4(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }


    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(12));

    }
}
