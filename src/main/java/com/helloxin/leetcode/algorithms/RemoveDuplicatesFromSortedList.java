package com.helloxin.leetcode.algorithms;


/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

import com.helloxin.leetcode.algorithms.preparation.ListNode;

/**
 * create by nandiexin on 2017/12/26
 **/
public class RemoveDuplicatesFromSortedList {



    public ListNode deleteDuplicates(ListNode head) {


        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
