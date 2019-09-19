package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yexin on 2019/9/18.
 * Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.

 Return a list of all powerful integers that have value less than or equal to bound.

 You may return the answer in any order.  In your answer, each value should occur at most once.

 Example 1:
 Input: x = 2, y = 3, bound = 10
 Output: [2,3,4,5,7,9,10]
 Explanation:
 2 = 2^0 + 3^0
 3 = 2^1 + 3^0
 4 = 2^0 + 3^1
 5 = 2^1 + 3^1
 7 = 2^2 + 3^1
 9 = 2^3 + 3^0
 10 = 2^0 + 3^2
 Example 2:
 Input: x = 3, y = 5, bound = 15
 Output: [2,4,6,8,10,14]
 Note:
 1 <= x <= 100
 1 <= y <= 100
 0 <= bound <= 10^6
 */
public class PowerfulIntegers970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                result.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(result);
    }

    public List<Integer> powerfulIntegers2(int x, int y, int bound) {
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i < bound; i *= x > 1? x : bound + 1) {
            for (int j = 1; i + j <= bound; j *= y > 1 ? y : bound + 1) {
                s.add(i + j);
            }
        }
        return new ArrayList<>(s);
    }
}
