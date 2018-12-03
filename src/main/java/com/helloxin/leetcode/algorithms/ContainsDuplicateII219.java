package com.helloxin.leetcode.algorithms;

import java.util.*;

/**
 * Created by nandiexin on 2018/11/30.
 */
public class ContainsDuplicateII219 {

    public static boolean containsDuplicate2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        int tag=0;
        for(int i = 0;i< nums.length;i++){
            Integer value = map.get(nums[i]);
            if(null !=map.put(nums[i],i)){
                if((i-value) <= k){
                   return true;
                }
            }
        }
        return false;
    }

    // 这里还直接用了删除的方法 保持在k的范围内
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) {
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
         int nums[]={1,0,1,1};
        System.out.println(containsDuplicate2(nums,1));
    }
}
