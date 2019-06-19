package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/6/12.
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 * <p>
 * 在此过程之后，我们得到一些数组 B。
 * <p>
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 * <p>
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 * <p>
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestRangeI908 {

    public int smallestRangeI(int[] A, int K) {

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int j = 0;j< A.length;j++){
             if(A[j] < min){
                 min = A[j];
             }
             if(A[j] > max){
                 max = A[j];
             }
        }
        int dif = max - min;
        if(dif<= 2*K){
            return 0;
        }
        int mindif = max -min -2*K;

        return Math.abs(mindif);
    }

    public static void main(String[] args) {

        SmallestRangeI908 smallestRangeI908 = new SmallestRangeI908();
        int nums[] = {9,9,2,8,7};
        System.out.println(smallestRangeI908.smallestRangeI(nums,4));

    }
}
