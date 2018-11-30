package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.ListNode;

/**
 * Created by nandiexin on 2018/11/29.
 Reverse a singly linked list.

 Example:

 Input: 1->2->3->4->5->NULL
 Output: 5->4->3->2->1->NULL
 Follow up:

 A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList206 {

    public static ListNode reverseList(ListNode head) {

        ListNode headNew = null;
        ListNode node = head;
        while(null != node){

            ListNode node2 = new ListNode(node.val);
            node2.next = headNew;
            headNew = node2;
            node = node.next;
        }
        return headNew;

    }


    public static void main(String[] args) {

        int array[] ={1,2,3,4,5};
        ListNode head = ListNode.buildeListNode(array);
        ListNode headNew =  reverseList(head);
        ListNode.printListNode(headNew);
    }
}
