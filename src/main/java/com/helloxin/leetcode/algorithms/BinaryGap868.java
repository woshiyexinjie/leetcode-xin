package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/5/10.
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 * <p>
 * 如果没有两个连续的 1，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 * <p>
 * 输入：5
 * 输出：2
 * 解释：
 * 5 的二进制是 0b101 。
 * 示例 3：
 * <p>
 * 输入：6
 * 输出：1
 * 解释：
 * 6 的二进制是 0b110 。
 * 示例 4：
 * <p>
 * 输入：8
 * 输出：0
 * 解释：
 * 8 的二进制是 0b1000 。
 * 在 8 的二进制表示中没有连续的 1，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 */
public class BinaryGap868 {

    public int binaryGap(int N) {
          String binaryStr = Integer.toBinaryString(N);
          //然后用两个指针一样 指定位置 选择最大的就行的

          return 1;
    }

    public int binaryGap2(int N) {
        int res = 0;
        for (int d = -32; N > 0; N /= 2, d++) {
            if (N % 2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
        }
        return res;
    }

    public int binaryGap3(int N) {
        int longest = 0;
        //for first match
        int prev = - 100;
        for(int i=31;i>=0;i--){
            int nthBit = (N<<i)>>>31;
            if(nthBit==1){
                int distance = prev-i;
                if(distance>longest) {
                    longest = distance;
                }
                prev = i;
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(12));

    }
}
