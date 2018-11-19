package com.helloxin.leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by nandiexin on 2018/11/17.
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

 Example 1:

 Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: [-1,-100,3,99] and k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 Note:

 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 Could you do it in-place with O(1) extra space?
 */
public class RotateArray189 {




    //使用双端队列 想怎么干怎么干 和利用的空间比较多
    public static int[] rotate(int[] nums, int k) {
        // ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque, LinkedList
        Deque deque = new ArrayDeque();
        for (int num:nums){
            deque.add(num);
        }
        for (int j = 0;j<k;j++){

            int last = (int) deque.getLast();
            deque.removeLast();
            deque.addFirst(last);
        }
        int m = 0;
        while (deque.peek()!= null){
           nums[m] = (int) deque.pop();
           m++;
        }
        System.out.println(Arrays.toString(nums));
        return nums;

    }

    public static int[] rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] kHolder = new int[k];
        System.arraycopy(nums, nums.length - k, kHolder, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(kHolder, 0, nums, 0, k);

        return kHolder;
    }

    public static int[] rotate3(int[] nums, int k) {
        if(k==0 || nums.length <2) {
            return nums;
        }
        int len = nums.length;
        int r = k % len;
        int[] temp = new int[len];
        for(int j=0; j<len; j++){
            temp[(j+r)%len] = nums[j];
        }
        System.arraycopy(temp, 0, nums, 0, temp.length);
        return temp;
    }

    public static void main(String[] args) {

        int array[] ={1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(rotate3(array,3)));
        int array2[] ={-1};
        System.out.println(Arrays.toString(rotate3(array2,3)));
        int array3[] ={1,2,3,4,5,6};
        System.out.println(Arrays.toString(rotate3(array3,11)));

    }
}
