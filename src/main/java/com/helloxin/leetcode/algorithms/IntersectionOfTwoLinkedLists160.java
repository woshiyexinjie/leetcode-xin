package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.ListNode;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nandiexin on 2018/11/20.
 *
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        //这么写还是有点趣的，因为查完A list然后接着是 Blist，那么这样就可以不用考虑长度不等啦
        while( a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if(headA==null || headB==null) {
            return null;
        }

        Set<ListNode> set = new HashSet<ListNode>();

        ListNode a = headA;
        ListNode b = headB;

        while(a!=null) {
            set.add(a);
            a=a.next;
        }
        while(b!=null)  {
            if(set.contains(b)) {
                return b;
            }
            b = b.next;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        System.in.read();
    }
}
