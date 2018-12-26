package com.helloxin.leetcode.algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nandiexin on 2018/12/24.
 *
 iven two arrays, write a function to compute their intersection.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Note:

 Each element in the result must be unique.
 The result can be in any order.
 */
public class IntersectionOfTwoArrays349 {


    public static  int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>  set = new HashSet<>();
        List<Integer> list = Arrays.stream(nums1).map(x->x).boxed().collect(Collectors.toList());
        for (int i = 0;i< nums2.length;i++){
            if(list.contains(nums2[i])){
                set.add(nums2[i]);
            }
        }

        int[] d = new int[set.size()];
        int i =0;
        for (int num : set) {
            d[i] = num;
            i++;
        }
        return d;
    }

//    public static  int[] intersection2(int[] nums1, int[] nums2) {
//
//        List<Integer> list = Arrays.stream(nums1).filter(x->Arrays.asList(nums2).contains(x)).boxed().collect(Collectors.toList());
//        int[] d = new int[list.size()];
//        int i =0;
//        for (int num : list) {
//            d[i++] = num;
//        }
//        return  d;
//    }

    public static void main(String[] args) {

        int nums1 [] = {1,2,2,1};
        int nums2 [] = {2,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));


    }

}
