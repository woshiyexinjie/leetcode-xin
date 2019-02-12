package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nandiexin on 2018/12/3.
 */
public class InvertBinaryTree226 {


    //使用递归的方式
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        TreeNode.printMidTreeNode(root.root);
        System.out.println();
        return root;
    }

    //使用Queue队列
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {


        TreeNode node = new TreeNode();
        int nums[] = {1,2,3,4,5,6,7,8,9};
        node.createTree(nums);
        TreeNode.printMidTreeNode(node.root);
        System.out.println();
        node = invertTree(node);
        TreeNode.printMidTreeNode(node.root);





    }
}
