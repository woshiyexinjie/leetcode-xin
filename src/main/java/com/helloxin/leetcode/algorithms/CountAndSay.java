package com.helloxin.leetcode.algorithms;


/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 */

/**
 * create by nandiexin on 2017/12/19
 **/
public class CountAndSay {

    public static  String countAndSay(int n) {
        if(n < 1) {
            return "";
        }

        String str = "1";
        for(int i = 1;i < n;++i){
            int count = 0;
            StringBuilder builder = new StringBuilder("");
            //根据str = "1" 这个标准 不断的往上算
            for(int j = 0;j < str.length();++j){
                ++count;
                //第二步 就是计算 后面有几个相等的 数字
                if((j + 1 < str.length()) && (str.charAt(j) != str.charAt(j + 1))){
                    builder = builder.append(count).append(str.charAt(j));
                    count = 0;
                }else if(j + 1 == str.length()){
                    builder = builder.append(count).append(str.charAt(j));
                }
            }
            str = builder.toString();
        }
        return str;
    }


    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(16));
    }
}
