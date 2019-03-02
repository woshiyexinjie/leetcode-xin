package com.helloxin.leetcode.algorithms;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nandiexin on 2019/2/28.

 Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

 Example 1:
 Input: [5, 4, 3, 2, 1]
 Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 For the left two athletes, you just need to output their relative ranks according to their scores.
 Note:
 N is a positive integer and won't exceed 10,000.
 All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks506 {

    public static String[] findRelativeRanks(int[] nums) {

        String result[] = new String[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        int nums2[]= nums.clone();
        Arrays.sort(nums2);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1) {
                result[map.get(nums2[i])] =  "Gold Medal";
                continue;
            }
            if(i==nums.length-2) {
                result[map.get(nums2[i])] = "Silver Medal";
                continue;
            }
            if(i==nums.length-3) {
                result[map.get(nums2[i])] =  "Bronze Medal";
                continue;
            }
            result[map.get(nums2[i])] = (nums.length-i) + "";
        }

        return result;
    }

    public String[] findRelativeRanks2(int[] nums) {
        int[][] pair = new int[nums.length][2];

        //这里用了二维数组存储数据 和上面的做法是类似的
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pair[i][1]] = "Gold Medal";
            }
            else if (i == 1) {
                result[pair[i][1]] = "Silver Medal";
            }
            else if (i == 2) {
                result[pair[i][1]] = "Bronze Medal";
            }
            else {
                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int nums[] ={10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(nums)));


    }

}
