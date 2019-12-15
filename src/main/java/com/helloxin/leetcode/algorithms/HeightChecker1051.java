package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by yebanxian on 2019/12/15.
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions
 */
public class HeightChecker1051 {

    //简单检查一下
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int count = 0;
        for(int i = 0; i < copy.length; i++){
            if(heights[i]!=copy[i]) {
                count++;
            }
        }
        return count;
    }
}
