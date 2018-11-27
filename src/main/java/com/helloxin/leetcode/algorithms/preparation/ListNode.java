package com.helloxin.leetcode.algorithms.preparation;

import java.util.ArrayList;
import java.util.List;

/**
 * create by nandiexin on 2017/12/14
 **/
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }


    public static void printListNode(ListNode head) {
        List list = new ArrayList();
        ListNode temp = head;
        while(null != temp){
            list.add(temp.val);
            temp = temp.next;
        }
        System.out.println(list);
    }

    public static ListNode buildeListNode(int[] array) {
        ListNode head = null;
        //当前节点
        ListNode temp = null;
        for (int i = 0;i< array.length;i++){
            if(i == 0){
                head = new ListNode(array[i]);
                temp = head;
            }else{
                ListNode newNode = new ListNode(array[i]);
                temp.next = newNode;
                temp = newNode;
            }
        }
        return head;
    }
}
