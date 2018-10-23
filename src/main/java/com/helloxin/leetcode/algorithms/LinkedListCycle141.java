package com.helloxin.leetcode.algorithms;

/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */

import com.helloxin.leetcode.algorithms.preparation.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2018/10/19.
 */
public class LinkedListCycle141 {


    /**
     * 这么写是会超时的
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        boolean result = false;
        ListNode current = head;
        List<ListNode> list = new ArrayList<>();
        if (null == head || null == current.next){
            return false;
        }
        while(null != current.next) {
            if (list.contains(head)) {
                return true;
            }
            current = current.next;
        }
        return true;
    }

    /**
     * 这么写居然过了，难道不会存在一个大环吗 题目意思不是很明确呀
     * 但是这样只是判断了相连两个节点
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

        if(head == null || head.next == null) {
            return false;
        }
        ListNode p = head;
        ListNode q = head;
        while( q != null && q.next != null){
            p = p.next;
            q = q.next.next;
            if( p == q){
                return true;
            }
        }
        return false;
    }


}
