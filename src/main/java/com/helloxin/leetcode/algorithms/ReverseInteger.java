package com.helloxin.leetcode.algorithms;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output:  321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment
 which could only hold integers within the 32-bit signed integer range.
 For the purpose of this problem,
 assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static int reverse(int x) {
        Long reverse = 0L;
        //默认为正数处理
        boolean flag = true;
        if (0==x){
            return x;
        }
        if(x < 0){
            flag = false;
        }
        int absoluteValue = Math.abs(x);
        while(absoluteValue > 0){
            reverse = reverse*10+absoluteValue%10;
            absoluteValue = absoluteValue /10;
        }
        if(!flag){
            reverse = -1 * reverse;
        }
        if(reverse > Integer.MAX_VALUE || reverse< Integer.MIN_VALUE){
            return 0;
        }
        return reverse.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
