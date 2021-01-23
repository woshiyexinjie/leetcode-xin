package com.helloxin.leetcode.algorithms.medium;


import com.helloxin.leetcode.algorithms.preparation.ListNumNode;

/**
 * Created by yebanxian on 2021/1/23.
 */
public class AddTwoNumbers2 {
    public ListNumNode addTwoNumbers(ListNumNode t1, ListNumNode t2) {
        ListNumNode l1 = t1;
        ListNumNode l2 = t2 ;
        Integer sum = l1.val + l2.val;
        ListNumNode beginNode = new ListNumNode(sum % 10) ;
        ListNumNode newNode = beginNode;
        int iterationRecord = sum / 10;
        while (l1.next != null && l2.next != null) {
            int tempSum = l1.next.val + l2.next.val + iterationRecord;
            ListNumNode tempNode = new ListNumNode(tempSum % 10);
            newNode.next = tempNode;
            iterationRecord = tempSum / 10;
            newNode = tempNode;
            l1 = l1.next;
            l2 = l2.next ;
        }
        if (l1.next == null) {
            while (l2.next != null) {
                int tempSum = l2.next.val + iterationRecord;
                ListNumNode tempNode = new ListNumNode(tempSum % 10);
                newNode.next = tempNode;
                iterationRecord = tempSum / 10;
                newNode = tempNode;
                l2 = l2.next ;
            }
        }
        if (l2.next == null) {
            while (l1.next != null) {
                int tempSum = l1.next.val + iterationRecord;
                ListNumNode tempNode = new ListNumNode(tempSum % 10);
                newNode.next = tempNode;
                iterationRecord = tempSum / 10;
                newNode = tempNode;
                l1 = l1.next;
            }
        }
        if (iterationRecord > 0) {
            ListNumNode tempNode = new ListNumNode(iterationRecord);
            newNode.next = tempNode;
            newNode = tempNode;
        }
        return beginNode;
    }

    public static void main(String[] args) {
        /**
         * Input: l1 = [2,4,3], l2 = [5,6,4]
         * Output: [7,0,8]
         * Explanation: 342 + 465 = 807.
         */
        ListNumNode a1 = new ListNumNode(9);
        ListNumNode a2 = new ListNumNode(9);
        ListNumNode a3 = new ListNumNode(9);
        a1.next = a2;
        a2.next = a3;

        ListNumNode b1 = new ListNumNode(9);
        ListNumNode b2 = new ListNumNode(9);
        ListNumNode b3 = new ListNumNode(9);
        b1.next = b2;
        b2.next = b3;
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        addTwoNumbers2.printNodeList(a1);
        addTwoNumbers2.printNodeList(b1);
        ListNumNode resultNode = addTwoNumbers2.addTwoNumbers(a1,b3);
        addTwoNumbers2.printNodeList(resultNode);
    }

    private void printNodeList(ListNumNode resultNode) {
        while(resultNode != null){
            System.out.print(resultNode.val+" ");
            resultNode = resultNode.next;
        }
        System.out.println();
    }
}
