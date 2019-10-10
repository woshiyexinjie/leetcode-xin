package com.helloxin.leetcode.algorithms;

/**
 * Created by yexin on 2019/10/10.
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 * Example 1:
 * <p>
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 * <p>
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 * <p>
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 */
public class FindTheTownJudge997 {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
