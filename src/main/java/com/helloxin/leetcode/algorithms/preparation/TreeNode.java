package com.helloxin.leetcode.algorithms.preparation;

import java.util.ArrayList;
import java.util.List;

/**
 * create by nandiexin on 2017/12/28
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;
    //用来存储节点
    private List<TreeNode> datas;

    public TreeNode(int x) { val = x; }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode() { }

    //虽然 不是我想要的结果 但是树还是有了
    public static TreeNode buildTreeNode(int[] num){
        TreeNode root = new TreeNode(num[0]);
        for (int i = 1;i<num.length;i++){
            TreeNode node = new TreeNode(num[i]);
            root.left = node;
        }

        return root;
    }

    public  void createTree(int[] nums) {
        datas = new ArrayList<TreeNode>();
        for (Integer object : nums) {
            datas.add(new TreeNode(object));
        }
        root = datas.get(0);//将第一个作为根节点
        for (int i = 0; i < nums.length / 2; i++) {
            datas.get(i).left = datas.get(i * 2 + 1);
            if (i * 2 + 2 < datas.size()) {//避免偶数的时候 下标越界
                datas.get(i).right = datas.get(i * 2 + 2);
            }
        }

    }



    //将树的信息输出 中序遍历
    public static void printMidTreeNode(TreeNode root){
           if(null != root){
               printMidTreeNode(root.left);
               System.out.print(root.val+" ");
               printMidTreeNode(root.right);
           }

    }

    //将树的信息输出 前序遍历
    public static void printPreTreeNode(TreeNode root){
        if(null != root){
            System.out.print(root.val+" ");
            printMidTreeNode(root.left);
            printMidTreeNode(root.right);
        }

    }

    //将树的信息输出 后序遍历
    public static void printLastTreeNode(TreeNode root){
        if(null != root){
            printMidTreeNode(root.left);
            printMidTreeNode(root.right);
            System.out.print(root.val+" ");
        }

    }
}
