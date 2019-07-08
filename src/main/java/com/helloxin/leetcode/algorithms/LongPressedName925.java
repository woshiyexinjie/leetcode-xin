package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/7/8.
 * <p>
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * <p>
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 * <p>
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 * <p>
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 * <p>
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * <p>
 * <p>
 * Note:
 * <p>
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */
public class LongPressedName925 {

    public static boolean isLongPressedName(String name, String typed) {
        char pre = ' ';

        for (int i = 0, j = 0; i < name.length(); ) {
            if (j >= typed.length()) {
                return false;
            }
            if (typed.charAt(j) == name.charAt(i)) {
                pre = name.charAt(i);
                i++;
                j++;
            } else {
                if (typed.charAt(j) == pre) {
                    j++;
                } else {
                    return false;
                }
            }

        }
        return true;

    }

    public static void main(String[] args) {

        System.out.println(isLongPressedName("pyplrz",
                "ppyypllr"));

    }
}
