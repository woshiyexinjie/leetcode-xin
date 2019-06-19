package com.helloxin.leetcode.algorithms.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nandiexin on 2019/5/24.
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * <p>
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence60 {

    static int[] facts = new int[10];
    static{
        facts[1] = 1;
        for (int i=2;i<=9;i++){
            facts[i] = facts[i-1]*i;
        }
    }
    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        List<Integer> digits = new LinkedList<Integer>();
        for (int i=1;i<=n;i++){
            digits.add(i);
        }
        k = k-1; //make zero based;4444
        while (k>0 && digits.size()>1){//k==0 means remaining digits in the list are ordered.
            int segmentLength = facts[digits.size()-1];
            int index =  k/segmentLength;
            k = k%segmentLength; //calculate new k
            s.append(digits.remove(index));
        }
        for (int i:digits){//add remaining digits
            s.append(i);
        }
        return s.toString();
    }
}
