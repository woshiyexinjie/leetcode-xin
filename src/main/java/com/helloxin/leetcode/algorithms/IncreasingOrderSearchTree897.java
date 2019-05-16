package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

/**
 * Created by nandiexin on 2019/5/16.
 */
public class IncreasingOrderSearchTree897 {

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }

    //使用中序遍历的方式 我们就可以得到我们的结果 然后组成我们想要的树
    TreeNode prev=null, head=null;
    public TreeNode increasingBST2(TreeNode root) {
        if(root==null) {
            return null;
        }
        increasingBST(root.left);
        if(prev!=null) {
            root.left=null;
            prev.right=root;
        }
        if(head==null) {
            head=root;
        }
        prev=root;
        increasingBST(root.right);
        return head;
    }

}
