package com.helloxin.leetcode.algorithms.medium;

import com.helloxin.leetcode.algorithms.preparation.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by nandiexin on 2019/5/30.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists23 {

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) {
            return null;
        }

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val) {
                    return -1;
                } else if (o1.val==o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists) {
            if (node!=null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
