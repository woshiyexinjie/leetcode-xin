package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by nandiexin on 2019/7/8.
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * <p>
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII922 {


    public int[] sortArrayByParityII(int[] A) {

        int cA[] = new int[A.length];
        int odd = 0;
        int even = 1;
        for (int i = 0; i < A.length; i++) {
            if(A[i]%2 == 1){
                cA[even] = A[i];
                even+=2;
            }else{
                cA[odd] = A[i];
                odd+=2;
            }
        }
        return cA;
    }

    public static void main(String[] args) {

        SortArrayByParityII922 sortArrayByParityII922 = new SortArrayByParityII922();
        int nums[]={4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII922.sortArrayByParityII(nums)));

    }

}
