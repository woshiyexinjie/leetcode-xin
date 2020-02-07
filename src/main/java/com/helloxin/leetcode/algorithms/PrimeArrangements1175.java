package com.helloxin.leetcode.algorithms;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by yebanxian on 2020/2/7.
 * Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
 * <p>
 * (Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)
 * <p>
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5
 * Output: 12
 * Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
 * Example 2:
 * <p>
 * Input: n = 100
 * Output: 682289015
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 100
 */
public class PrimeArrangements1175 {
    public int numPrimeArrangements(int n) {
        int cnt = 1; // # of primes, first prime is 2.
        outer:
        for (int i = 3; i <= n; i += 2) { // only odd number could be a prime, if i > 2.
            for (int factor = 3; factor * factor <= i; factor += 2) {
                if (i % factor == 0) {
                    continue outer;
                }
            }
            ++cnt;
        }
        long ans = 1;
        for (int i = 1; i <= cnt; ++i) {
            ans = ans * i % 1_000_000_007;
        }
        for (int i = 1; i <= n - cnt; ++i) {
            ans = ans * i % 1_000_000_007;
        }
        return (int)ans;
    }
}
