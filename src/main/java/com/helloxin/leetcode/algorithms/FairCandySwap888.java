package com.helloxin.leetcode.algorithms;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * Created by nandiexin on 2019/5/15.
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 * <p>
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 */
public class FairCandySwap888 {

    //时间复杂度 n^2
    public int[] fairCandySwap(int[] A, int[] B) {
        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        HashSet<Integer> S = new HashSet<>();
        for (int a : A) {
            S.add(a);
        }
        for (int b : B) {
            if (S.contains(b + dif)) {
                return new int[]{b + dif, b};
            }
        }
        return new int[0];
    }
}
