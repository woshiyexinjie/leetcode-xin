package com.helloxin.leetcode.algorithms;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

/**
 * Created by nandiexin on 2019/1/7.
 *
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example :

 Input: n = 10, pick = 6
 Output: 6
 */
public class GuessNumberHigherOrLower374 {


    //全部查一遍 除了效率不行 还是能完成任务的
    public static int guessNumber(int n) {
           for (int i =1;i<=n;i++){
               if(guess(i)==0){
                   return i;
               }
           }
           return Integer.MIN_VALUE;
    }

    //二分查找
    public static int guessNumber2(int n) {

        int low = 1;
        int high = n;
        while(low <= high){

            int mid = low + (high - low) / 2;
            //这种写法可能会溢出
//            int mid =  (high + low) / 2;
            int guess = guess(mid);
            if(guess == 0){
                return mid;
            }
            if(guess < 0){
                high = mid -1;
            }
            if(guess > 0){
                low = mid+1;
            }

        }
        return Integer.MIN_VALUE;
    }

    //看到其他的solution 写了三分搜索 和二分其实是差不多的
    public static int guessNumber3(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0) {
                return mid1;
            }
            if (res2 == 0) {
                return mid2;
            } else if (res1 < 0) {
                high = mid1 - 1;
            } else if (res2 > 0) {
                low = mid2 + 1;
            } else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return Integer.MIN_VALUE;
    }


    public static int guess(int n){
        return Objects.compare(12,n, Comparator.naturalOrder());
    }

    public static void main(String[] args) {

        System.out.println(guessNumber2(15));

    }


}
