package com.helloxin.leetcode.algorithms;

/**
 * Created by yexin on 2019/9/24.
 */
public class RottingOranges994 {

    private int rot(int[][] g, int i, int j, int d) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 1) {
            return 0;
        }
        g[i][j] = d + 3;
        return 1;
    }
    public int orangesRotting(int[][] g) {
        int fresh = 0, d = 0;
        for (int[] aG : g) {
            for (int anAG : aG) {
                if (anAG == 1) {
                    ++fresh;
                }
            }
        }
        for (int old_fresh = fresh; fresh > 0; ++d, old_fresh = fresh) {
            for (int i = 0; i < g.length; ++i) {
                for (int j = 0; j < g[i].length; ++j) {
                    if (g[i][j] == d + 2) {
                        fresh -= rot(g, i + 1, j, d) + rot(g, i - 1, j, d) + rot(g, i, j + 1, d) + rot(g, i, j - 1, d);
                    }
                }
            }
            if (fresh == old_fresh) {
                return -1;
            }
        }
        return d;
    }
}
