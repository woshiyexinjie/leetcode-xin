package com.helloxin.leetcode.algorithms;


/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nandiexin on 2018/10/17.
 */
public class SingleNumber136 {


    /**
     * 使用神奇的map
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        if(nums.length == 1){
            return nums[0];
        }
        for (int  i = 0;i< nums.length;i++){
           Integer nu = map.get(nums[i]);
           if(null == nu){
               nu = 1;
           }else{
               nu ++;
           }
           map.put(nums[i],nu);
        }
        for(Integer key:map.keySet()){
              if(map.get(key)==1){
                  return key;
              }
        }
        return -1;
    }



    //下面是学霸的答题方式

    public static int singleNumber3(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }

    public static int singleNumber2(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(i == 0){
                if(nums[0] != nums[1]){
                    return nums[0];
                }
            }else if(i == nums.length - 1){
                if(nums[nums.length - 2] != nums[nums.length - 1]){
                    return nums[nums.length - 1];
                }
            }else if(nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] num = {-1,-1,-2};
        System.out.println(singleNumber2(num));
    }
}
