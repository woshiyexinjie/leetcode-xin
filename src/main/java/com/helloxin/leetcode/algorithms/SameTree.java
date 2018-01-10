package com.helloxin.leetcode.algorithms;

/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.


Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 */

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.Stack;

/**
 * create by nandiexin on 2017/12/28
 **/
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
    }

    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        // iteration method
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.add(p);
        stackQ.add(q);
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode tmpP = stackP.pop();
            TreeNode tmpQ = stackQ.pop();
            if (tmpP.val != tmpQ.val) {
                return false;
            }
            if (tmpP.getLeft() != null && tmpQ.getLeft() != null) {
                stackP.push(tmpP.getLeft());
                stackQ.push(tmpQ.getLeft());
            } else if (tmpP.getLeft() == null && tmpQ.getLeft() == null) {
            } else {
                return false;
            }
            if (tmpP.getRight() != null && tmpQ.getRight() != null) {
                stackP.push(tmpP.getRight());
                stackQ.push(tmpQ.getRight());
            } else if (tmpP.getRight() == null && tmpQ.getRight() == null) {
            } else {
                return false;
            }
        }
        if (!stackP.isEmpty() || !stackQ.isEmpty()) {
            return false;
        }
        return true;
    }
}
