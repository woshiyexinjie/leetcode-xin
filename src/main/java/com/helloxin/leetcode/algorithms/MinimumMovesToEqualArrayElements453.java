package com.helloxin.leetcode.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by nandiexin on 2019/2/12.
 *
 Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 *
 */
public class MinimumMovesToEqualArrayElements453 {

    //这是一道数学题 但是不知道怎么做
    public static int minMoves(int[] nums) {
        return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
    }

    public static void main(String[] args) {
        int num[] ={-1,1};
        System.out.println(minMoves(num));
    }
}
