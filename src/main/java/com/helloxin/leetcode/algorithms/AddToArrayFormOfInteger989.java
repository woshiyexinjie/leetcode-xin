package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yexin on 2019/9/23.
 */
public class AddToArrayFormOfInteger989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }

    //使用 arrayList 应该成本比较大 复制
    public List<Integer> addToArrayForm2(int[] A, int K) {
        List res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; --i) {
            res.add(0, (i >= 0 ? A[i] + K : K) % 10);
            K = (i >= 0 ? A[i] + K : K) / 10;
        }
        return res;
    }
}
