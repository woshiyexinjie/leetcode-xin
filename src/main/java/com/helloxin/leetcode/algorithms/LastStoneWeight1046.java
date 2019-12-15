package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yebanxian on 2019/12/15.
 * We have a collection of rocks, each rock has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone
 */
public class LastStoneWeight1046 {

    //使用 PriorityQueue 优先队列 获取最大的两个值
    public int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : A) {
            pq.offer(a);
        }
        for (int i = 0; i < A.length - 1; ++i) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }

    public int lastStoneWeight2(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int i : stones) {
            list.add(i);
        }

        while (list.size() > 1) {
            //这里需要排序一下 比起优先队列的堆 比较耗时间
            Collections.sort(list);
            Integer y = list.get(list.size() - 1);
            Integer x = list.get(list.size() - 2);
            if (!y.equals(x)) {
                list.remove(x);
                list.remove(y);
                y = y - x;
                list.add(y);
            } else {
                list.remove(x);
                list.remove(y);
            }
        }
        return list.size() == 0 ? 0 : list.get(0);
    }
}
