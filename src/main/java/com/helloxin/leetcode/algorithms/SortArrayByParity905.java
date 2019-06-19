package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by nandiexin on 2019/6/4.
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class SortArrayByParity905 {

    //按照交换的方式 类似冒泡排序
    public static int[] sortArrayByParity(int[] A) {

        for (int j = 0; j < A.length - 1; j++) {
            for (int i = 0; i < A.length - 1 - j; i++) {
                int temp = Integer.MAX_VALUE;
                if (A[i] % 2 == 1) {
                    temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
        }
        return A;
    }

    //使用空间来降低时间
    public static int[] sortArrayByParity2(int[] A) {

        int B[] = new int[A.length];
        int j =0,k= A.length-1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
               B[j] = A[i];
               j++;
            }else{
                B[k] =A[i];
                k--;
            }
        }
        return B;
    }

    //使用两个指针，如果遇到偶数就放到前面去
    public static int[] sortArrayByParity3(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        }
        return A;
    }

    public static void main(String[] args) {

//        int arr[] = {3, 1, 2, 4};
//        System.out.println(Arrays.toString(sortArrayByParity2(arr)));
        int i = 500;
        for (int j = 0; j < 50; j++)
            i = ++i;
        System.out.println(i);



    }
}
