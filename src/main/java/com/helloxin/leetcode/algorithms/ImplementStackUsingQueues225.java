package com.helloxin.leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nandiexin on 2018/12/3.
 */
public class ImplementStackUsingQueues225 {

    public ImplementStackUsingQueues225() {

    }


    private Queue<Integer> q = new LinkedList<Integer>();

    public void push(int x) {
        q.add(x);
        for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
