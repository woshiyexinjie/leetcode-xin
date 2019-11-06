package com.helloxin.leetcode.algorithms;

/**
 * A boomerang is a set of 3 points that are all distinct and not in a straight line.
 * <p>
 * Given a list of three points in the plane, return whether these points are a boomerang.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,3],[3,2]]
 * Output: true
 * Example 2:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: false
 * The other idea is to calculate the slope of AB and AC.
 * K_AB = (p[0][0] - p[1][0]) / (p[0][1] - p[1][1])
 * K_AC = (p[0][0] - p[2][0]) / (p[0][1] - p[2][1])
 * <p>
 * We check if K_AB != K_AC, instead of calculate a fraction.
 */
public class ValidBoomerang1037 {
    public boolean isBoomerang(int[][] p) {
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }
}
