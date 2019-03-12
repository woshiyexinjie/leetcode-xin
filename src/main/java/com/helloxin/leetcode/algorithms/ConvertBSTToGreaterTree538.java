package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

/**
 * Created by nandiexin on 2019/3/12.
 */
public class ConvertBSTToGreaterTree538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);

        root.val += sum;
        sum = root.val;

        convertBST(root.left);

        return root;
    }
}
