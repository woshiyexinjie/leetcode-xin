package com.helloxin.leetcode.algorithms;
/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * create by nandiexin on 2018/1/5
 **/
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public static int maxDepthDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }

    public static int maxDepthBFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode temp = root;

        for (int i= 1; i<=1000;i++){
            TreeNode node = new TreeNode(i);
            temp.right = node;
            temp = node;
        }
        long begin = System.currentTimeMillis();
        System.out.println("begin："+begin);
        System.out.println(maxDepthDFS(root));
        System.out.println("end："+(System.currentTimeMillis()-begin)+"ms");
    }
}
