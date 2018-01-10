package com.helloxin.leetcode.algorithms;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

/**
 * create by nandiexin on 2018/1/10
 **/
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = minDepth(root.left), R = minDepth(root.right);
        return 1 + (Math.min(L, R) > 0 ? Math.min(L, R) : Math.max(L, R));
    }
}
