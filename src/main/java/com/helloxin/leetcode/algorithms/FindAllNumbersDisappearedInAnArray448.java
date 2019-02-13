package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2019/2/12.
 *
 *Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 */
public class FindAllNumbersDisappearedInAnArray448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {


        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=nums.length;i++){
            list.add(i);
        }
        for(int j= 0;j< nums.length;j++){
           if(list.contains(nums[j])){
               list.remove(Integer.valueOf(nums[j]));
           }
        }
         return list;

    }

    public static void main(String[] args) {
        int nums[] = {1,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
