package com.helloxin.leetcode.algorithms;
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

import com.helloxin.leetcode.algorithms.preparation.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * create by nandiexin on 2018/1/7
 **/
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) {
            return wrapList;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().getLeft() != null) {
                    queue.offer(queue.peek().getLeft());
                }
                if(queue.peek().getRight() != null) {
                    queue.offer(queue.peek().getRight());
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.getLeft(), level+1);
        levelMaker(list, root.getRight(), level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
