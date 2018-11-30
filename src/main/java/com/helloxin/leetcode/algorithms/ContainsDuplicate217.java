package com.helloxin.leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by nandiexin on 2018/11/30.
 Given an array of integers, find if the array contains any duplicates.

 Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

 Example 1:

 Input: [1,2,3,1]
 Output: true
 Example 2:

 Input: [1,2,3,4]
 Output: false
 Example 3:

 Input: [1,1,1,3,3,4,3,2,4,2]
 Output: true
 */
public class ContainsDuplicate217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums) {
            //这里用了set，其实set是去重的，虽然判断size也行，但是效率比不上中间过程就可以判断
            //add方法里面用的也是 map的put 其实用map就行了
            if(!set.add(i))
            {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for(int i : nums) {
            if(map.put(i,i) != null)
            {
                return true;
            }
        }
        return false;
    }

    //当然还有一种做法是 我可以开辟和数组一样大的数组 或者使用map放入中，根据value的值来判断
    //当然实践复杂度不考虑的话 那么可以每个都便利一遍判断
}
