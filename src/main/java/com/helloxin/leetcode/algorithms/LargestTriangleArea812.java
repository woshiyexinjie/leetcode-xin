package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/4/29.
 * <p>
 * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
 * <p>
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the largest.
 * <p>
 * <p>
 * Notes:
 * <p>
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 * -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 */
public class LargestTriangleArea812 {

    public double largestTriangleArea(int[][] points) {
        double area = 0.0;
        for (int i = 0; i < points.length; i++) {
            int[] a = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] b = points[j];
                for (int k = j + 1; k < points.length; k++) {
                    int[] c = points[k];
                    area = Math.max(area, getArea(a, b, c));
                }
            }
        }
        return area;
    }

    // calculate the area using cross product divided by 2
    public double getArea(int[] a, int[] b, int[] c) {
        return Math.abs(((a[0] - b[0]) * (a[1] - c[1]) - (a[0] - c[0]) * (a[1] - b[1])) / 2.0);
    }
}
