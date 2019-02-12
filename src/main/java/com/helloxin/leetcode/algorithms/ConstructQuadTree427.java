package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.Node;

/**
 * Created by nandiexin on 2019/1/24.
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.
 * <p>
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 * <p>
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:
 * <p>
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 */
public class ConstructQuadTree427 {

    public Node construct(int[][] g) {
        return build(0, 0, g.length - 1, g.length - 1, g);
    }

    Node build(int r1, int c1, int r2, int c2, int[][] g) {
        if (r1 > r2 || c1 > c2) {
            return null;
        }
        boolean isLeaf = true;
        int val = g[r1][c1];
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (g[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
        }
        if (isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        }
        int rowMid = (r1 + r2) / 2, colMid = (c1 + c2) / 2;
        return new Node(false, false,
                build(r1, c1, rowMid, colMid, g),  //top left
                build(r1, colMid + 1, rowMid, c2, g),  //top right
                build(rowMid + 1, c1, r2, colMid, g),  //bottom left
                build(rowMid + 1, colMid + 1, r2, c2, g));  //bottom right
    }


    public Node construct2(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    private Node helper(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }

        Node nodeTL = helper(grid, x, y, len / 2);
        Node nodeTR = helper(grid, x, y + len / 2, len / 2);
        Node nodeBL = helper(grid, x + len / 2, y, len / 2);
        Node nodeBR = helper(grid, x + len / 2, y + len / 2, len / 2);
        // Merge all child nodes
        if (nodeTL.isLeaf && nodeTR.isLeaf && nodeBL.isLeaf && nodeBR.isLeaf) {
            if (nodeTL.val && nodeTR.val && nodeBL.val && nodeBR.val) {
                return new Node(true, true, null, null, null, null);
            }
            if (!nodeTL.val && !nodeTR.val && !nodeBL.val && !nodeBR.val) {
                return new Node(false, true, null, null, null, null);
            }
        }
        return new Node(true, false, nodeTL, nodeTR, nodeBL, nodeBR);
    }
}
