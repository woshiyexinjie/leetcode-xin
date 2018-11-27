package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.ListNode;
import javafx.util.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by nandiexin on 2018/11/27.
 *
 *
 Remove all elements from a linked list of integers that have value val.

 Example:

 Input:  1->2->6->3->4->5->6, val = 6
 Output: 1->2->3->4->5


 */
public class RemoveLinkedListElements203 {

    public static ListNode removeElements(ListNode head, int val) {

        ListNode temp = head;
        ListNode pre = null;
        while(null != temp) {
            if (temp.val == val) {

                if (null == pre) {
                    head = temp.next;
                }else{
                    pre.next = temp.next;
                }

            }else {
                pre = temp;
            }
            temp = temp.next;


        }
        return head;
    }


    public static void main(String[] args) {

//        int array[] = {1,2,2,1};
        int array[] = {1,2,6,3,4,5,6};
        ListNode head = ListNode.buildeListNode(array);
        ListNode.printListNode(head);
        ListNode.printListNode(removeElements(head,6));

    }
}
