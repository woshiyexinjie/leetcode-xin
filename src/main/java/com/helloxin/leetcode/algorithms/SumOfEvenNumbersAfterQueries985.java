package com.helloxin.leetcode.algorithms;

/**
 * Created by yexin on 2019/9/23.
 */
public class SumOfEvenNumbersAfterQueries985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0, i = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                sum += a;
            }
        } // sum of even #s.
        int[] ans = new int[queries.length];
        for (int[] q : queries) {
            if (A[q[1]] % 2 == 0) {
                sum -= A[q[1]];
            } // from 1) and 2)
            A[q[1]] += q[0];
            if (A[q[1]] % 2 == 0) {
                sum += A[q[1]];
            } // from 2) and 3)
            ans[i++] = sum;
        }
        return ans;
    }
}
