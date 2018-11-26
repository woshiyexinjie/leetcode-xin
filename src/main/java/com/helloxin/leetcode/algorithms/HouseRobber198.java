package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/11/23.
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber198 {

    /**
     * 这个系统给我返回了Time Limit Exceeded 怎么可以优化一下呢 是不是因为复制数组浪费空间 这里用了递归
     * 我想的是在偷第n家的，他不是可以知道前面怎么偷的吗 那边就有点像斐波那契数列
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] numsnew = new int[nums.length - 1];
        int[] numsnew2 = new int[nums.length - 2];
        System.arraycopy(nums, 0, numsnew, 0, nums.length - 1);
        System.arraycopy(nums, 0, numsnew2, 0, nums.length - 2);
        int a = rob(numsnew);
        int b = rob(numsnew2) + nums[nums.length - 1];
        return a > b ? a : b;
    }

    /*
      那么就迭代一下吧 慢慢向前推导
     */
    public static int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] numsnew = new int[nums.length];
        if(nums.length > 0) {
            numsnew[0] = nums[0];
        }
        if(nums.length > 1) {
            numsnew[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int length = nums.length;
        int i =2;
        while(i<length){
            numsnew[i] = (numsnew[i-1] > numsnew[i-2]+nums[i])?numsnew[i-1]:numsnew[i-2]+nums[i];
            i++;
        }
        return numsnew[length-1];
    }

    public static void main(String[] args) {

        int nums[] = {2,7,9,3,1};
        System.out.println(rob2(nums));
    }
}
