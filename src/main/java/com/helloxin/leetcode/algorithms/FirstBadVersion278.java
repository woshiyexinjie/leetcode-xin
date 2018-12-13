package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/12/12.
 ou are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

 Example:

 Given n = 5, and version = 4 is the first bad version.

 call isBadVersion(3) -> false
 call isBadVersion(5) -> true
 call isBadVersion(4) -> true

 Then 4 is the first bad version.
 */
public class FirstBadVersion278 {

    //暴力一点就像这样吧
    public int firstBadVersion(int n) {

        for (int i = 1;i<= n;i++){
            if(isBadVersion(i)){
                return i;
            }
        }
        return 0;
    }

    //那么写个二分查找吧
    public int firstBadVersion2(int n) {
        int start=1;
        int end = n;
        while (start < end){
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }



    private boolean isBadVersion(int i) {

        return true;
    }


}
