package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/17.
 * <p>
 * <p>
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlowers605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {


        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed.length == 1) {
                if ((flowerbed[i] == 0 && n == 1)||(flowerbed[i] == 1 && n == 0) ||(flowerbed[i] == 0 && n == 0)) {
                    return true;
                } else {
                    return false;
                }
            }
            if (flowerbed[i] == 0 && i == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if (flowerbed[i] == 0 && i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if ((i != 0 && i != flowerbed.length - 1)&&flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
                //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if(next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count == n;
    }

    public static void main(String[] args) {
        int candies[] = {1,0};
        System.out.println(canPlaceFlowers(candies,1));
    }
}
