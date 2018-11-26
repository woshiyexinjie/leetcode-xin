package com.helloxin.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nandiexin on 2018/11/26.

 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber202 {

    public static  boolean isHappy(int n) {

        boolean result = false;
        if (n < 10) {
            return n == 1 || n == 7;
        }
        int newsum = 0;
        while (n != 0) {
            int digit = n % 10;
            newsum += digit*digit;
            n /= 10;
        }
        return isHappy(newsum);

    }

    public boolean isHappy2(int n) {
        if(n == 1111111) {
            return true;
        }

        int[] digitSquare = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

        int happyNum;
        do {
            happyNum = 0;
            while(n != 0) {
                happyNum += digitSquare[n%10];
                n /= 10;
            }

            if(happyNum == 1) {
                return true;
            } else if(happyNum < 10) {
                return false;
            } else {
                n = happyNum;
            }
        } while (happyNum != 0);

        return false;
    }

    public boolean isHappy3(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }

        }
        return false;

    }


    public static void main(String[] args) {

        int n = 5;
        System.out.println(isHappy(n));

    }


}
