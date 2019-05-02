package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nandiexin on 2019/5/2.
 * <p>
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * <p>
 * 最终结果按照字典顺序输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 * <p>
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 * <p>
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 */
public class PositionsOfLargeGroups830 {


    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, j = 0; i < S.length(); i = j) {
            while (j < S.length() && S.charAt(j) == S.charAt(i)) {
                ++j;
            }
            if (j - i >= 3) {
                res.add(Arrays.asList(i, j - 1));
            }
        }
        return res;
    }

    public List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() <= 2) {
            return res;
        }

        int slow = 0;
        int fast = 0;
        while (fast < S.length()) {
            char c = S.charAt(slow);
            while (fast + 1 < S.length() && S.charAt(fast + 1) == c) {
                fast++;
            }
            if (fast - slow + 1 >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(slow);
                list.add(fast);
                res.add(list);
            }
            fast++;
            slow = fast;
        }
        return res;
    }
}
