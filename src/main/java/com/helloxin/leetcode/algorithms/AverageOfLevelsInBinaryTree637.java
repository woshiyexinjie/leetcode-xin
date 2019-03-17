package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by nandiexin on 2019/3/17.
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 Example 1:
 Input:
 3
 / \
 9  20
 /  \
 15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 Note:
 The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelsInBinaryTree637 {

    //这里使用了集合层级遍历树
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) {
            return result;
        }
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(sum / n);
        }
        return result;

    }
}
