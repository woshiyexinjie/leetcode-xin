package com.helloxin.leetcode.algorithms;

/**
 * Created by yebanxian on 2020/2/12.
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 */
public class MaximumNumberOfBalloons1189 {

    /**
     * balloon   b1 a1 l2 02 n1
     * @param text
     * @return
     */
    public static int maxNumberOfBalloons(String text) {

        int count[] = new int[26];
        int num = 0;
        for(char a : text.toCharArray()){
            count[a-'a']++;
        }
        int numa= count['a'-'a'];
        int numb= count['b'-'a'];
        int numl= count['l'-'a'];
        int numo= count['o'-'a'];
        int numn= count['n'-'a'];
        num =Math.min(Math.min(Math.min(Math.min(numa,numb),numl/2),numo/2),numn);
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
}
