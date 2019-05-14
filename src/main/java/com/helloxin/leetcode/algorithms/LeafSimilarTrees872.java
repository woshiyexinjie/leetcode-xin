package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.Stack;

/**
 * Created by nandiexin on 2019/5/14.
 */
public class LeafSimilarTrees872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root1); s2.push(root2);
        while (!s1.empty() && !s2.empty()) {
            if (dfs(s1) != dfs(s2)) {
                return false;
            }
        }
        return s1.empty() && s2.empty();
    }

    public int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
            if (node.left == null && node.right == null) {
                return node.val;
            }
        }
    }

    StringBuilder tree1 = new StringBuilder();
    StringBuilder tree2 = new StringBuilder();
    private void leafSimilarHelper(TreeNode root, StringBuilder str){
        if(root == null) {
            return;
        }
        leafSimilarHelper(root.left, str);
        if(root.left == null && root.right == null){
            str.append(root.val);
        }
        leafSimilarHelper(root.right, str);
    }

    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        leafSimilarHelper(root1, tree1);
        leafSimilarHelper(root2, tree2);
        //System.out.print(tree1 + " "+ tree2);
        return tree1.toString().equals(tree2.toString());
    }
}
