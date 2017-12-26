package com.helloxin.leetcode.algorithms;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.


Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

/**
 * create by nandiexin on 2017/12/26
 **/
public class ClimbingStairs {

    /**
     * 这是 discuss 里面大神写的  奈何我无法理解
     * Same simple algorithm written in every offered language.
     * Variable a tells you the number of ways to reach the current step,
     * and b tells you the number of ways to reach the next step.
     * So for the situation one step further up,
     * the old b becomes the new a, and the new b is the old a+b,
     * since that new step can be reached by climbing 1 step from what b represented or 2 steps
     * from what a represented
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            a = (b += a) - a;
        }
        return a;
    }

    /**
     * 这样就好理解多了
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1; dp[1] = 2;
        for (int i = 2; i < n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
