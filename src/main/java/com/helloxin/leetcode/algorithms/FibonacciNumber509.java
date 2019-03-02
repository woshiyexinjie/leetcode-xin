package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/1.

 The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), for N > 1.
 Given N, calculate F(N).



 Example 1:

 Input: 2
 Output: 1
 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 Example 2:

 Input: 3
 Output: 2
 Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 Example 3:

 Input: 4
 Output: 3
 Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class FibonacciNumber509 {


    //先用递归的方法 来编写
    public static int fib(int N) {

        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }

        return fib(N-1)+fib(N-2);
    }


    //这样 速度上会比递归快很多
    public static int fib2(int N) {

        int fib0 = 0;
        int fib1 = 1;
        if(N==0){
            return fib0;
        }
        if(N==1){
            return fib1;
        }
        for(int i =2;i<=N;i++){
            int temp = fib1;
            fib1 = fib1+fib0;
            fib0 =  temp;
        }
        return fib1;
    }




    public static void main(String[] args) {

        System.out.println(fib2(4));

    }

}
