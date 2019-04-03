package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/4/3.
 */
public class FindSmallestLetterGreaterThanTarget744 {

    //败了败了  原来我想的是开始就遍历一遍呗
    //可能还不需要全部遍历完 当然那是最差的情况 平均应该是n/2吧


    public char nextGreatestLetter(char[] a, char target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return a[l] > target ? a[l] : a[0];
    }


    public char nextGreatestLetter2(char[] a, char x) {
        int n = a.length;

        if (x >= a[n - 1]) {
            x = a[0];
        } else {
            x++;
        }

        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == x) {
                return a[mid];
            }
            if (a[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return a[hi];
    }
}
