package com.helloxin.leetcode.algorithms;


/**
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such
 that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.Stack;

/**
 * Created by nandiexin on 2018/1/17.
 */
public class PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<> ();
        stack.push(root) ;
        while (!stack.isEmpty() && root != null){
            TreeNode cur = stack.pop() ;
            if (cur.left == null && cur.right == null){
                if (cur.val == sum ) {
                    return true ;
                }
            }
            if (cur.right != null) {
                cur.right.val = cur.val + cur.right.val ;
                stack.push(cur.right) ;
            }
            if (cur.left != null) {
                cur.left.val = cur.val + cur.left.val;
                stack.push(cur.left);
            }
        }
        return false ;
    }

}
