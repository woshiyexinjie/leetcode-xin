package com.helloxin.leetcode.algorithms;

/**
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ] */


import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nandiexin on 2018/1/17.
 */
public class PathSumII {


    //头大  学习前辈们的经验

    private List<List<Integer>> resultList = new ArrayList<List<Integer>>();


    public void pathSumInner(TreeNode root, int sum, Stack<Integer> path) {
        path.push(root.val);
        if(root.left == null && root.right == null) {
            if(sum == root.val) {
                resultList.add(new ArrayList<Integer>(path));
            }
        }
        if(root.left!=null) {
            pathSumInner(root.left, sum-root.val, path);
        }
        if(root.right!=null) {
            pathSumInner(root.right, sum-root.val, path);
        }
        path.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) {
            return resultList;
        }
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, sum, path);
        return resultList;
    }


    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            }
            if(cur.left==null && cur.right==null && SUM==sum) {
                res.add(new ArrayList<Integer>(path));
            }

            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;

        }
        return res;
    }

    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, res, path);
        return res;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
        if(root==null) return;
        path.add(root.val);

        if(root.left==null && root.right==null ){
            if(root.val==sum)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        if(root.left!=null) {
            dfs(root.left,sum-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            dfs(root.right,sum-root.val,res,path);
            path.remove(path.size()-1);
        }

    }


    public static void main(String[] args) {
        System.out.println("");
    }
}
