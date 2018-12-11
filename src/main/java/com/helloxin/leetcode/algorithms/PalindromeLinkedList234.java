package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by nandiexin on 2018/12/10.
 *
 Given a singly linked list, determine if it is a palindrome.

 Example 1:

 Input: 1->2
 Output: false
 Example 2:

 Input: 1->2->2->1
 Output: true
 */
public class PalindromeLinkedList234 {

    //我想用java提供的范儿集合实现会简单一点 但是开销比较大
    public static boolean isPalindrome(ListNode head) {
         if(null == head){
            return true;
         }
         Deque<Integer> deque = new ArrayDeque<>();
         while (head != null){
             deque.addFirst(head.val);
             head = head.next;
         }
         while(!deque.isEmpty()){
             if(deque.size()>=2) {
                 if(deque.removeLast().intValue() != deque.removeFirst().intValue()){
                     return false;
                 }
             }else{
                 return true;
             }
         }
         return true;

    }

    public static boolean isPalindrome2(ListNode head) {

        ListNode reverse = reverse(head);
        while(head != null){
            if(head.val != reverse.val){
                return  false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;

    }

    private static ListNode reverse(ListNode head) {
        ListNode node = head;
        //指向最新的元素
        ListNode pre = null;
        ListNode low = null;

        while(node != null){
            ListNode newNode = new ListNode(node.val);
            if(low == null) {
                pre = newNode;
                low = newNode;
            }else{
                low = pre;
                pre = newNode;
                pre.next = low;
            }
            node = node.next;
        }
        return pre;
    }


    public static void main(String[] args) {
        int nums[] ={1,2,2,1};
        ListNode hah = ListNode.buildeListNode(nums);
        System.out.println(isPalindrome2(hah));

    }
}
