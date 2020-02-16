package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by yebanxian on 2020/2/16.
 * Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 * <p>
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 * <p>
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurrences1207 {

    public static boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        //这里用map会不会效率更高
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                if (list.contains(count)) {
                    return false;
                }
                list.add(count);
                count = 0;
            }
            count++;
        }
        //如果用的循环 那么别忘记了最后的值
        if (list.contains(count)) {
            return false;
        }
        return true;
    }

    //我居然忘记了set这种数据结构
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr) {
            count.put(a, 1 + count.getOrDefault(a, 0));
        }
        return count.size() == new HashSet<>(count.values()).size();
    }

    public static void main(String[] args) {
        int arr[] = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(uniqueOccurrences(arr));
    }
}
