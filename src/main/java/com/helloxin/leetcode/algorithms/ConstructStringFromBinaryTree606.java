package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

/**
 * Created by nandiexin on 2019/3/17.
 */
public class ConstructStringFromBinaryTree606 {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right == "") {
            return result;
        }
        if (left == "") {
            return result + "()" + "(" + right + ")";
        }
        if (right == "") {
            return result + "(" + left + ")";
        }
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
