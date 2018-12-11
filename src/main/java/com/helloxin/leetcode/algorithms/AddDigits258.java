package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/12/11.
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 Example:

 Input: 38
 Output: 2
 Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 Since 2 has only one digit, return it.
 */
public class AddDigits258 {

    //常规操作
    public static int addDigits(int num) {

        int result = num;
        while(result >=10){
             int sum = result;
             result = 0;
             while(sum>0){
                 result+=sum%10;
                 sum = sum/10;
             }
        }
        return result;
    }

    //看到别人这么写的  怎么推算的 不想动脑啦
    public int addDigits2(int num) {
        if (num == 0){
            return 0;
        }
        if (num % 9 == 0){
            return 9;
        }
        else {
            return num % 9;
        }
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
