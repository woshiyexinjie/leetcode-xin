package com.helloxin.leetcode.algorithms;

/**
 *
 Created by nandiexin on 2018/12/26.
 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example 1:

 Input: a = 1, b = 2
 Output: 3
 Example 2:

 Input: a = -2, b = 3
 Output: 1

 */
public class SumOfTwoIntegers371 {


    //不能使用 + -
    public static int getSum(int a, int b) {

        return b==0? a:getSum(a^b, (a&b)<<1);
    }

    public static int getSum2(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }





    public static void main(String[] args) {

        System.out.println(getSum(2,1));

    }

}
