package com.helloxin.leetcode.algorithms.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by nandiexin on 2019/5/23.
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class MergeIntervals56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        List<int[]> list = new ArrayList<>();
        for (int[] in : intervals) {
            list.add(in);
        }

        Collections.sort(list, (a, b) -> a[0] - b[0]); // increased sort by start

        List<int[]> merged = new ArrayList<>();
        int start = list.get(0)[0], end = list.get(0)[1];
        for (int i = 1; i < list.size(); ++i) {
            if (end >= list.get(i)[0]) {
                end = Math.max(list.get(i)[1], end);
            } else {
                merged.add(new int[]{start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        merged.add(new int[]{start, end});

        int[][] res = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); ++i) {
            res[i] = merged.get(i);
        }
        return res;
    }

}
