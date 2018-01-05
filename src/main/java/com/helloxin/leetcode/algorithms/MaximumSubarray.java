package com.helloxin.leetcode.algorithms;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
/**
 * create by nandiexin on 2017/12/20
 **/
public class MaximumSubarray {

      //一个是全局最优，就是到当前元素为止最优的解是，一个是局部最优，就是必须包含当前元素的最优的解。
      // 接下来说说动态规划的递推式（这是动态规划最重要的步骤，递归式出来了
      //如果需要我输出subarray  该怎么写呢？
      public static int maxSubArray(int[] nums) {
          int global=nums[0], local=nums[0];
          for (int i=1;i<nums.length;++i){
              local= Math.max(local+nums[i],nums[i]);
              global=Math.max(global, local);
          }
          return global;
      }
}
