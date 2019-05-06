package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/5/6.
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * <p>
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * <p>
 * 而这一个不是：
 * 384
 * 519
 * 762
 * <p>
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */
public class MagicSquaresInGrid840 {

    //抄的 不想做
    public int numMagicSquaresInside(int[][] grid) {
        int cnt=0;
        for(int i=0;i<=grid.length-3;i++) {
            for(int j = 0; j<=grid[0].length-3; j++) {
                if(helper(i,j,grid)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean helper(int x,int y,int[][] grid){
        if(grid[x+1][y+1]!=5) {
            return false;
        }

        int[] valid=new int[16];

        for(int i=x;i<=x+2;i++) {
            for(int j = y; j<=y+2; j++) {
                valid[grid[i][j]]++;
            }
        }

        for (int v = 1; v <= 9; v++) {
            if (valid[v] != 1) {
                return false;
            }
        }

        if((grid[x][y]+grid[x][y+1]+grid[x][y+2])!=15) {
            return false;
        }
        if((grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2])!=15) {
            return false;
        }
        if((grid[x][y]+grid[x+1][y]+grid[x+2][y])!=15) {
            return false;
        }
        if((grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2])!=15) {
            return false;
        }
        if((grid[x][y+2]+grid[x+1][y+2]+grid[x+2][y+2])!=15) {
            return false;
        }
        if((grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y])!=15) {
            return false;
        }
        return true;
    }
}
