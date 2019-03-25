package com.helloxin.leetcode.algorithms.preparation;

import java.util.List;

/**
 * Created by nandiexin on 2019/3/21.
 */
public class Employee {

    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
