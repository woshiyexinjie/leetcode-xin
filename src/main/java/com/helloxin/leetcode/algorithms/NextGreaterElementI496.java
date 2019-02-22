package com.helloxin.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by nandiexin on 2019/2/22.
 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

 nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

 示例 1:

 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 输出: [-1,3,-1]
 解释:
 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 示例 2:

 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 输出: [3,-1]
 解释:
 对于num1中的数字2，第二个数组中的下一个较大数字是3。
 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 */
public class NextGreaterElementI496 {

    //简单的思想逻辑
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int result[] = new int[nums1.length];
        for (int i= 0;i<nums1.length;i++){
            result[i]=nextGreate(nums2,nums1[i]);
        }
        return result;
    }

    public static int nextGreate(int [] nums2,int base){
        int n =0;
        for(int j = 0;j<nums2.length;j++ ){
            if(nums2[j] == base){
                n= j;
                break;
            }
        }
        for(int j = n;j<nums2.length;j++ ){
            if(nums2[j]>base){
                return nums2[j];
            }
        }
        return -1;
    }

    //抽象出来就是遍历一次 然后使用map的操作
    public static int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        return findNums;
    }


    public static void main(String[] args) {

        int nums1[]={4,1,2};
        int nums2[]={3,1,4,2};

        System.out.println(Arrays.toString(nextGreaterElement2(nums1,nums2)));

    }

}
