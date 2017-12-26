package com.helloxin.leetcode.algorithms;



/*

Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer,
 the decimal part will be truncated.

 */

import java.util.HashMap;
import java.util.Map;

/**
 * create by nandiexin on 2017/12/25
 **/
public class Sqrt_x {

    /**
     * 最简朴的思想是这样的 只是耗时和空间比较大
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
          if(x > Integer.MAX_VALUE){
              throw new IllegalArgumentException("参数不合法");
          }
          int i = 0;
          while(i * i <= x) {
              if(i * i == x){
                  i++;
                  break;
              }
              i++;
          }
          return i-1;
    }

    /**
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        return (int)Math.sqrt(x);
    }


    /**
     * 想改进一下 上面最质朴的 方案
     * @param x
     * @return
     */
    public static int mySqrt3(int x) {
        if(x > Integer.MAX_VALUE){
            throw new IllegalArgumentException("参数不合法");
        }
        long r = x;
        while ( r * r > x ) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }

    /**
     * 二分查找
     * @param x
     * @return
     */
    public static int mySqrt4(int x) {
        if(x > Integer.MAX_VALUE){
            throw new IllegalArgumentException("参数不合法");
        }
        if (0 == x) {
            return 0;
        }
        int left = 1, right = x, ans=-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt4(2147395600));
        System.out.println(289398*289398);
        System.out.println(46340*46340);
        System.out.println(2147395600);
    }
}
