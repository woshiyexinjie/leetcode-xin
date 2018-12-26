package com.helloxin.leetcode.algorithms;

import java.util.*;

/**
 * Created by nandiexin on 2018/12/24.
 */
public class IntersectionOfTwoArraysII350 {

    //这种使用map 一般都可以解决  可能效率没有那么快
    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        //
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i], 1);
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map2.containsKey(nums2[j])) {
                map2.put(nums2[j], map2.get(nums2[j]) + 1);
            }else{
                map2.put(nums2[j], 1);
            }
        }
        for (Integer key : map.keySet()) {

            int length1= map.get(key);
            int length2=map2.get(key) == null?0:map2.get(key);
            int kl = length1> length2?length2:length1;

            for(int k = 0;k<kl;k++){
                list.add(key);
            }


        }
         int d[] = new int[list.size()];
         for (int m =0;m<list.size();m++){
              d[m] = list.get(m);
         }
         return d;

    }

    //类似的 只是简化一下
    public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i])+1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }

        return r;
    }



    public static void main(String[] args) {
        int nums1 [] = {1,2,2,1};
        int nums2 [] = {2,2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }


}
