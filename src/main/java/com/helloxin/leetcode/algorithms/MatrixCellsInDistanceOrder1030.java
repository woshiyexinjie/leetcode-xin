package com.helloxin.leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yexin on 2019/11/5.
 * We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

 Additionally, we are given a cell in that matrix with coordinates (r0, c0).

 Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)



 Example 1:

 Input: R = 1, C = 2, r0 = 0, c0 = 0
 Output: [[0,0],[0,1]]
 Explanation: The distances from (r0, c0) to other cells are: [0,1]
 */
public class MatrixCellsInDistanceOrder1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] origin = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                origin[i * C + j] = new int[] {i, j};
            }
        }

        Arrays.sort(origin, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return Math.abs(a[0] - r0) + Math.abs(a[1] - c0)
                        - Math.abs(b[0] - r0) - Math.abs(b[1] - c0);
            }
        });
        return origin;
    }
}
