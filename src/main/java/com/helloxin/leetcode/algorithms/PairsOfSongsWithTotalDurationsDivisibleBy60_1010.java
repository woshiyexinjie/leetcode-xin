package com.helloxin.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yexin on 2019/10/15.
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 * <p>
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 * <p>
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60_1010 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int d = (60 - t % 60) % 60;
            ans += count.getOrDefault(d, 0);
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0));
        }
        return ans;
    }
}
