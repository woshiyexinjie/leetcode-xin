package com.helloxin.leetcode.algorithms;

/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2018/1/22.
 */
public class PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = null;
        for (int i = 0; i <= rowIndex ; i++) {
            list = getPascalsList(list);
        }
        return list;
    }

    private static List<Integer> getPascalsList(List<Integer> front) {

        List<Integer> pascal = new ArrayList<>();
        if (null == front){
            pascal.add(1);

        }else{
            pascal.add(1);
            for (int i = 1; i < front.size(); i++) {
                pascal.add(front.get(i-1)+front.get(i));
            }
            pascal.add(1);
        }
        return pascal;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return list;
        }

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(getRow(5));

    }
}
