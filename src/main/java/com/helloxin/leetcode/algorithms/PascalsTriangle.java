package com.helloxin.leetcode.algorithms;

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2018/1/22.
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows < 1){
            return list;
        }
        List<Integer> front = null;
        for (int i = 0; i < numRows; i++) {
            if ( i > 0) {
                front = list.get(i-1);
            }
            List<Integer>  pascals =  getPascalsList(front);
            list.add(pascals);
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


    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <=0){
            return triangle;
        }
        for (int i=0; i<numRows; i++){
            List<Integer> row =  new ArrayList<Integer>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

}
