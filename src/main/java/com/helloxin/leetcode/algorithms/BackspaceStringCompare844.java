package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/5/7.
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 */
public class BackspaceStringCompare844 {

    public boolean backspaceCompare(String S, String T) {
        return trans(S).equals(trans(T));
    }

    private String trans(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } // if not '#', append it at the end of sb.
            else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            } // remove last char in sb, if sb is not empty.
        }
        return sb.toString();

    }
}