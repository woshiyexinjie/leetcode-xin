package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yexin on 2019/9/18.
 * A binary tree is univalued if every node in the tree has the same value.

 Return true if and only if the given tree is univalued.
 */
public class UnivaluedBinaryTree965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root.left != null) {
            if (!isUnivalTree(root.left)) {
                return false;
            }
            if (root.left.val != root.val) {
                return false;
            }
        }

        if (root.right != null) {
            if (isUnivalTree(root.right)) {
                return root.right.val == root.val;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isUnivalTree2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.val != root.val) { return false; }
            if (n.left != null) { q.offer(n.left); }
            if (n.right != null) { q.offer(n.right); }
        }
        return true;
    }

    public boolean isUnivalTree3(TreeNode root) {
        return dfs(root, root.val);
    }
    private boolean dfs(TreeNode n, int v) {
        if (n == null) { return true; }
        if (n.val != v) { return false; }
        return dfs(n.left, v) && dfs(n.right, v);
    }
}
