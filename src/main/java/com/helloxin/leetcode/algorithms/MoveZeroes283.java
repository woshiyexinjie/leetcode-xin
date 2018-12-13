package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by nandiexin on 2018/12/13.
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 */
public class MoveZeroes283 {

    //我是想做一个交换 将0往后移
    public static void moveZeroes(int[] nums) {

        int length =nums.length;
        int count= 0;
        LOOP:for (int i = 0;i<length;i++){

            if(nums[i] == 0){
                count = i+1;
                if(count == length){
                    break LOOP;
                }
                while(nums[count] == 0){
                    count ++;
                    if(count == length){
                        break LOOP;
                    }
                }
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    //但是看到很多人提交 都是将非0 往前移动
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    //简化一下
    public static void moveZeroes3(int[] nums) {
        //慢一点走的j
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            System.out.println(Arrays.toString(nums));
        }
    }


    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};
        moveZeroes3(nums);
    }

}
