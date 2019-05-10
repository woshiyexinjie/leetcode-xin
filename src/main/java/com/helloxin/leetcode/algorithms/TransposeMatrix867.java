package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/5/10.
 */
public class TransposeMatrix867 {

    public int[][] tranpose(int[][] A) {
        int M = A.length, N = A[0].length;
        int[][] B = new int[N][M];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }

}
