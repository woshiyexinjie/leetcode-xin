package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by nandiexin on 2019/2/12.
 *
 Given an array of characters, compress it in-place.

 The length after compression must always be smaller than or equal to the original array.

 Every element of the array should be a character (not int) of length 1.

 After you are done modifying the input array in-place, return the new length of the array.


 Follow up:
 Could you solve it using only O(1) extra space?


 Example 1:

 Input:
 ["a","a","b","b","c","c","c"]

 Output:
 Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

 Explanation:
 "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".


 Example 2:

 Input:
 ["a"]

 Output:
 Return 1, and the first 1 characters of the input array should be: ["a"]

 Explanation:
 Nothing is replaced.


 Example 3:

 Input:
 ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

 Output:
 Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

 Explanation:
 Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 Notice each digit has it's own entry in the array.


 Note:

 All characters have an ASCII value in [35, 126].
 1 <= len(chars) <= 1000.
 *
 */
public class StringCompression443 {

    public static int compress(char[] chars) {

        int charNUm[] = new int[92];
        char anchor = (char)(35);
        for (int i=0;i<chars.length;i++){
            charNUm[chars[i]-anchor]++;
        }
        int num = 0;
        for (int i=0;i<charNUm.length;i++){
            if(charNUm[i]>1){
                num++;
                num+= (charNUm[i]+"").length();
            }else if(charNUm[i] ==1){
                num++;
            }
        }
        return num;

    }

    //上面那个居然会给我报错 奇怪的错误但是 这个方法居然不会
    public int compress2(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        return indexAns;
    }

    public static void main(String[] args) {


        char chars[] = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));

    }
}
