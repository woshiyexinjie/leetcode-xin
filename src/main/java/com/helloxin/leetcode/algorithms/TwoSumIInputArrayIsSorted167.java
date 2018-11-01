package com.helloxin.leetcode.algorithms;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

 Note:

 Your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution and you may not use the same element twice.
 Example:

 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]
 Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

import java.util.Arrays;

/**
 * Created by nandiexin on 2018/10/23.
 */
public class TwoSumIInputArrayIsSorted167 {

    /**
     * 简单一点 我们就全部遍历一遍
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {

        int sum[] = new int[2];
        int i= 0,j=0;
        //这里使用break加标志符号跳出指定循环，其实也可以加一个boolean值判断
        out:for (;i<numbers.length;i++){
            for(j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j] == target){
                    break out;
                }
            }
        }
        sum[0]=++i;
        sum[1]=++j;
        return sum;
    }

    /**
     * 在1的基础上优化一下
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {

        int sum[] = new int[2];
        int i= 0,j=0;
        //这里使用break加标志符号跳出指定循环，其实也可以加一个boolean值判断
        out:for (;i<numbers.length;i++){
            for(j=i+1;j<numbers.length;j++){
                //如果是已经排好序的 那么大于target的时候就不用比较了
                if(numbers[i]+numbers[j] > target){
                    //j=numbers.length-1;
                    break;
                }
                if(numbers[i]+numbers[j] == target){
                    break out;
                }
            }
        }
        sum[0]=++i;
        sum[1]=++j;
        return sum;
    }

    /*
      这样的时间复杂度就降低了很多 O（n），比起上面的O（n^2）
     */
    public static int[] twoSum3(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while(low < high){
            if(numbers[low] + numbers[high] < target){
                low++;
                continue;
            }
            else if (numbers[low] + numbers[high] > target){
                high--;
                continue;
            }
            else {
                return new int[] {low+1, high+1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        int array[] = {2,7,11,15};
//        System.out.println(Arrays.toString(twoSum3(array,9)));

    }
}
