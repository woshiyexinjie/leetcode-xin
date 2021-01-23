package com.helloxin.leetcode.algorithms.medium;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;


public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

