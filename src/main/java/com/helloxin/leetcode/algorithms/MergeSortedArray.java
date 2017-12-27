package com.helloxin.leetcode.algorithms;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.


 */

/**
 * create by nandiexin on 2017/12/27
 **/
public class MergeSortedArray {

    /*
      这里题目要求合到 num1中  如果还可以起来一个中间数据先保存 num1 ，在对num1重新赋值 又是另一个++的计算
     */
    public static void merge(int A[], int m, int B[], int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1) {
            A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
        }
        while (j>-1) {
            A[k--] = B[j--];
        }
    }
}
