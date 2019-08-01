package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */

public class RangeSumOfBST938 {

    //这里用了广度遍历
    public int rangeSumBST(TreeNode root, int L, int R) {

        int result = 0;
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.val >= L && node.val <= R) {
                result += node.val;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    //原来还想着怎么 处理在递归到节点为 null的时候怎么处理
    //这里是让递归返回加起来 当然这里是建立在二叉搜索树的情况下
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        //放弃左边的 往右搜索
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }


}
