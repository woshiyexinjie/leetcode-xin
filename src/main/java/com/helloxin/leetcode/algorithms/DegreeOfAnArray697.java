package com.helloxin.leetcode.algorithms;

import java.util.*;

/**
 * Created by nandiexin on 2019/3/27.
 *
 *
 Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 Note:

 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray697 {

    public int findShortestSubArray(int[] nums) {

         Map<Integer,Integer> map = new HashMap<>();
         for (Integer a:nums){
             int src = map.get(a) ==null?1:(map.get(a)+1);
             map.put(a,src);
         }
         List<Integer> list = new ArrayList<>();
         int max = Integer.MIN_VALUE;
         for(Map.Entry<Integer, Integer> entry : map.entrySet()){

             if(entry.getValue() > max){
                 max = entry.getValue();
                 list.clear();
                 list.add(entry.getKey());
             }else if (entry.getValue() == max){
                 list.add(entry.getKey());
             }
         }
         int minlength = nums.length;
         for(Integer num:list){
             int len = findLast(nums,num)-findpre(nums,num)+1;
             if(len < minlength){
                 minlength = len;
             }
         }
         return minlength;

    }

    private int findLast(int[] nums, Integer num) {
        for(int i= nums.length-1;i>=0;i--){
            if(nums[i] == num){
                return i;
            }
        }
        return 0;
    }

    private int findpre(int[] nums, Integer num) {
        for(int i= 0;i<nums.length;i++){
            if(nums[i] == num){
                return i;
            }
        }
        return 0;

    }

    public static void main(String[] args) {

        DegreeOfAnArray697 degreeOfAnArray697 = new DegreeOfAnArray697();
        int nums[]={1,2,2,3,1,4,2};
        System.out.println(degreeOfAnArray697.findShortestSubArray(nums));

    }
}
