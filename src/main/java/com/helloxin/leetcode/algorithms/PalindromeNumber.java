package com.helloxin.leetcode.algorithms;

import java.util.ArrayList;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {

    /**
     * 判断是不是回文数 我想就是判断 字符串反转 是不是和原来的相等 当然是用Stack栈 先进后出也是这样的效果
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {

        boolean result = false;
        StringBuffer numStr = new StringBuffer(x+"");
        if (numStr.toString().equals(numStr.reverse().toString())){
            result = true;
        }
        return result;
    }

    /**
     * 转换成字符串是比较偷懒的，然后现在我们就用 数值类型判断下
     * 这边比较麻烦的就是0的处理
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {

        //负数
        if(x < 0) {
            return false;
        }

        int len = 1;
        while(x / len >= 10) {
            len *= 10;
        }

        while(x > 0){
            System.out.println(x+" "+len);
            //获取头尾数据  这边左边0处理 会比 len 小
            int left = x / len;
            int right = x % 10;

            if(left != right) {
                return false;
            }
            else  {
                //移除头尾数据
                x = (x % len) / 10;
                len /= 100;
            }
        }
        return true;
    }

    /**
     * reverse string
     * @param s
     * @return
     */
    public static String reverse2(String s) {
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }

    /**
     * 以前写 c++ 干过不少这样的  因为C++中String类型的可以向数组这样处理，但是java需要调用charAt方法
     * @param orig
     * @return
     */
    public static String reverse3(String orig) {
        char[] s = orig.toCharArray();
        int n = s.length - 1;
        int halfLength = n / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = s[i];
            s[i] = s[n - i];
            s[n - i] = temp;
        }
        return new String(s);
    }

    /**
     * 一般情况下 有现成的方法 也不会去用这个异或操作
     * @param s
     * @return
     */
    public static  String reverse4(String s) {

        char[] str = s.toCharArray();

        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            str[begin] = (char) (str[begin] ^ str[end]);
            str[end] = (char) (str[begin] ^ str[end]);
            str[begin] = (char) (str[end] ^ str[begin]);
            begin++;
            end--;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(reverse2("123456789"));
        System.out.println(reverse3("123456789"));
        System.out.println(reverse4("123456789"));

    }
}
