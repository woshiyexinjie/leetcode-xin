package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/7/5.
 * <p>
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * <p>
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * <p>
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * <p>
 * <p>
 * Note:
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class ReverseOnlyLetters917 {

    public static String reverseOnlyLetters(String S) {

        //用两个指针呢
        StringBuilder builder = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j; ) {
            if (!Character.isLetter(S.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetter(S.charAt(j))) {
                j--;
                continue;
            }
            char c = S.charAt(i);
            builder.setCharAt(i, S.charAt(j));
            builder.setCharAt(j, c);
            i++;
            j--;
        }
        return builder.toString();

    }

    public static void main(String[] args) {

        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));

    }


}
