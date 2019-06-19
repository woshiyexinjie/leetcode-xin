package com.helloxin.leetcode.algorithms.medium;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2019/5/21.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater42 {

    public static int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }
        int maxL = height[0];
        int[] maxRs = new int[height.length];
        int waterSum = 0;//计算总的水量
        int maxR = 0;
        for(int i = height.length - 1; i >= 0; i--){
            if(height[i] > maxR) {
                maxRs[i] = maxR = height[i];
            }
            else {
                maxRs[i] = maxR;
            }
        }
        for(int i = 1; i < height.length - 1; i++){
            if(height[i] > maxL) {
                maxL = height[i];//更新左边最大值
            }
            waterSum += Math.max(Math.min(maxL, maxRs[i]) - height[i], 0);
        }
        return waterSum;

    }


    public static void main(String[] args) {

        int nums[] = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0, 1,2,1,3,4,6,8,1,3 };
        System.out.println(trap(nums));

        System.out.println(nums.length);

    }
}
