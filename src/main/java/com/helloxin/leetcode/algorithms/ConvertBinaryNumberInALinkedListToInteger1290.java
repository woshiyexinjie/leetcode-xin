package com.helloxin.leetcode.algorithms;

import com.helloxin.leetcode.algorithms.preparation.ListNode;

/**
 * Created by yebanxian on 2019/12/18.
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 * <p>
 * Input: head = [0]
 * Output: 0
 * Example 3:
 * <p>
 * Input: head = [1]
 * Output: 1
 * Example 4:
 * <p>
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 * <p>
 * Input: head = [0,0]
 * Output: 0
 */

public class ConvertBinaryNumberInALinkedListToInteger1290 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }

    public int getDecimalValue2(ListNode head) {
        int num = 0;
        while(head!=null) {
            num <<= 1;
            num += head.val;
            head = head.next;
        }
        return num;
    }
}
