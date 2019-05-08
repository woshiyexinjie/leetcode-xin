package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nandiexin on 2019/5/7.
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * <p>
 * 至少有一个空座位，且至少有一人坐在座位上。
 * <p>
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * <p>
 * 返回他到离他最近的人的最大距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * <p>
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 提示：
 * <p>
 * 1 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 */
public class MaximizeDistanceToClosestPerson849 {

    public int maxDistToClosest(int[] seats) {

        int maxDis = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                list.add(i);
            }
        }
        for (int j = 0; j < seats.length; j++) {
            if (seats[j] == 0) {
                int mid = etMaxDis(j, list);
                if (mid > maxDis) {
                    maxDis = mid;
                }
            }
        }
        return maxDis;


    }

    private int etMaxDis(int j, List<Integer> list) {
        int shortDis = Integer.MAX_VALUE;
        if(list.size() == 0){
            return j;
        }
        for (int a : list) {
            int mid = Math.abs(a - j);
            if (mid < shortDis) {
                shortDis = mid;
            }
        }
        return shortDis;

    }

    // 这种写法 都是空位 到底是最大是多少  其实我觉得都是空位
    public int maxDistToClosest2(int[] seats) {
        int i, j, res = 0, n = seats.length;
        for (i = j = 0; j < n; ++j) {
            if (seats[j] == 1) {
                if (i == 0) {
                    res = j;
                } else {
                    res = Math.max(res, (j - i + 1) / 2);
                }
                i = j + 1;
            }
        }
        res = Math.max(res, n - i);
        return res;
    }


    public int maxDistToClosest3(int[] seats) {
        int j, n = seats.length;
        int maxContinue = 0;
        int continuel=0;
        int continuef=0;
        int continuee=0;
        boolean firch = false;
        for (j = 0; j < n; ++j) {
            if(seats[j] == 0){
                continuel++;
            }else{
                if(firch == false){
                    continuef = continuel;
                }
                if(continuel> maxContinue){
                    maxContinue = continuel;
                }
                continuel =0;
                firch =true;
            }
        }
        continuee = continuel;
        int mid = (maxContinue+1)/2;
        return Math.max(Math.max(mid,continuef),continuee);

    }


    public static void main(String[] args) {

        int seats[] = {1,0,0,0,1,0,1};
        MaximizeDistanceToClosestPerson849 maximizeDistanceToClosestPerson849 = new MaximizeDistanceToClosestPerson849();
        System.out.println(maximizeDistanceToClosestPerson849.maxDistToClosest3(seats));
    }
}
