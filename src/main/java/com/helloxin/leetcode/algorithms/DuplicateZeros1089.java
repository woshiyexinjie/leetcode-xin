package com.helloxin.leetcode.algorithms;

import java.util.LinkedList;

/**
 * Created by yebanxian on 2019/12/15.
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class DuplicateZeros1089 {
    public void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZero++;
            }
        }
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            } else {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
                j--;
                if (j < arr.length) {
                    arr[j] = arr[i]; //copy twice when hit '0'
                }
            }
        }
    }

    public void duplicateZeros2(int[] a) {
        int i = 0, sh = 0;
        for (i = 0; sh + i < a.length; ++i) {
            sh += a[i] == 0 ? 1 : 0;
        }
        for (i = i - 1; sh > 0; --i) {
            if (i + sh < a.length) {
                a[i + sh] = a[i];
            }
            if (a[i] == 0) {
                a[i + --sh] = a[i];
            }
        }
    }
    public void duplicateZeros3(int[] arr) {
        LinkedList<Integer> queue=new LinkedList<Integer>();
        for(int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if(arr[i] == 0) {
                //add another 0
                queue.add(arr[i]);
            }
            arr[i] = queue.poll();
        }
    }
}
