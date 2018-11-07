package com.helloxin.leetcode.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by nandiexin on 2018/11/2.
 *
  Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:

 Input: [3,2,3]
 Output: 3
 Example 2:

 Input: [2,2,1,1,1,2,2]
 Output: 2
 */
public class MajorityElement169 {

    //使用map来实现 一个萝卜一个坑   当然如果时间复杂度o(n^2)
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        int n =-1;
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i])+1;
                map.put(nums[i],value);
            }else{
                map.put(nums[i],1);
            }
        }
        //这里遍历有很多方法啦
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        int num = nums.length/2;
        while(iterator.hasNext()){
             n = iterator.next();
             if(map.get(n) > num){
                 return n;
             }
        }

       return n;
    }

    // Moore voting algorithm 摩尔投票算法

    public static int majorityElement2(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count == 0) {
                ret = num;
            }
            if (num != ret) {
                count--;
            } else {
                count++;
            }
        }
        return ret;
    }

    // Bit manipulation
    public static int majorityElement3(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums) {
            for (int i = 0; i<32; i++) {
                if ((num>>(31-i) & 1) == 1) {
                    bit[i]++;
                }
            }
        }
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,4,5,6,7};
        System.out.println(majorityElement2(nums));
    }
}
