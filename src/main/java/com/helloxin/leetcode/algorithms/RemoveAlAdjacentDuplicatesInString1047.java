package com.helloxin.leetcode.algorithms;

import java.util.Stack;

/**
 * Created by yebanxian on 2019/12/15.
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */
public class RemoveAlAdjacentDuplicatesInString1047 {

    //使用指针的方式
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]){
                i -= 2;
            }
        }
        return new String(res, 0, i);
    }

    //这种用stack的数据结构是比较解决问题的
    public String removeDuplicates2(String S) {
        if(S == null || S.length() == 0) {
            return new String();
        }
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                while(!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                    stack.pop();
                }
            } else {
                stack.push(S.charAt(i));
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
