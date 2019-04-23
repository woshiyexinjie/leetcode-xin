package com.helloxin.leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by nandiexin on 2019/4/20.
 * <p>
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class LetterCasePermutation784 {

    //使用广度搜索 BFS 这个比较好理解 知道这个树的层数 那么就可以一层层地剥夺
    public static List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                continue;
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }

    //DFS 一直查询到底 知道世界尽头 只是你要知道哪里是世界的尽头
    public List<String> letterCasePermutation2(String S) {
        if (S == null) {
            return new LinkedList<>();
        }

        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    public void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);
    }


    public static void main(String[] args) {


        System.out.println(letterCasePermutation("a1b2"));

    }


}
