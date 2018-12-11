package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

/**
 * Created by nandiexin on 2018/12/3.
 */
public class InvertBinaryTree226 {

    public TreeNode invertTree(TreeNode root) {

         if(null != root){
             TreeNode temp = root.right;
             root.right = root.left;
             root.left = temp;
         }else{
             return null;
         }
        invertTree(root.right);
        invertTree(root.right);
        return root;

    }


    public static void main(String[] args) {


        TreeNode node = new TreeNode();
        int nums[] = {1,2,3,4,5,6,7,8,9};
        node.createTree(nums);
        TreeNode.printTreeNode(node.root);

    }
}
