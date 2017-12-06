package com.helloxin.leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 问题描述
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

   may assume that each input would have exactly one solution, and you may not use the same element twice.

   Example:
   Given nums = [2, 7, 11, 15], target = 9,

   Because nums[0] + nums[1] = 2 + 7 = 9,
   return [0, 1].
 *
 */

public class TwoSum {

    /**
     *  这边用了两个循环 全部遍历一下
     *  这样的时间复杂度O(n^2),空间复杂度O(1)
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 这里 j = i + 1 我这边理解的element 只能是同一个位置了 同一个数值是可以的
            for (int j = i + 1; j < nums.length; j++) {
                // target ==  nums[j] + nums[i]  与这样写有区别吗？
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        //这行我是看了leetcode解答后加上的
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 这边使用了HashMap 来匹配数据，先要初始化一个HashMap的数据，用了空间换时间，修改第二个For循环
     * 虽然这样提高了性能，时间复杂度降了下来，但是失去了很大的拓展性
     * 这边的要求是假设每个输入都有确定的一个解，不能使用同一个数字两次，
     * 当然题目用的element，我就不知道是同一个位置的数据，还是同一个值，难理解，其实得到的结果某些情况和方法一是不一样的
     * 但是如果里面有重复数字的时候，你知道Map初始化就已经覆盖掉了，会得到后面的值
     * 这样的时间复杂度O(n),空间复杂度O(n)
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //初始化 map 中的数据
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //使用map containsKey来获取有没有匹配的值 使用了map是不能存在相同的key
            // 使用 nums 数据在外层循环 ，内层 map 中其实只有除去重复 key 的数据了
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 我看 solution 还写了这样一个，我是想不到了哈
     * 前面我们用了一个循环来初始化 map 中的数据，其实我们还可以延迟初始化
     * 因为既然两个是成对的，你来找我，还是我找你 是一样的
     * 但是因为是map 延迟的初始化，里面的数据就和twoSum2的初始化的数据 value不一样了
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {

        int nums[] = {2,7,5,3};
        int target = 9;
        int result[] = twoSum(nums,target);
//        int result[] = twoSum2(nums,target);
//        int result[] = twoSum3(nums,target);
        Arrays.stream(result).forEach(x-> System.out.print(x+" "));
        System.out.println();
    }
}
