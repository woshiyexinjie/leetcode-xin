package com.helloxin.leetcode.algorithms;

/**
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
 1000~3000: {"M", "MM", "MMM"}.
 */
public class RomanToInteger {

    //这题目真是让人头大  因为我还要知道罗马数字是怎么样 表示数字的
    /**
     * 罗马数字与十进位数字的意义不同,它没有表示零的数字,与进位制无关.
     * 用罗马数字表示数的基本方法一般是把若干个罗马数字写成一列,它表示的数等于各个数字所表示的数相加的和.
     * 但是也有例外,当符号Ⅰ、Ⅹ或C位于大数的后面时就作为加数；位于大数的前面就作为减数.
     * 例如：Ⅲ=3,Ⅳ=4,Ⅵ=6,ⅩⅨ=19,ⅩⅩ=20,ⅩLⅤ=45,MCMLXXX=1980.
     * 罗马数字因书写繁难,所以,后人很少采用.现在有的钟表表面仍有用它表示时数的.
     * 此外,在书稿章节及科学分类时也有采用罗马数字的.
     */

    public static int romanToInt(String s) {
        if(null == s || s.isEmpty() || s.length() == 0){
            throw new RuntimeException("s can't be null or empty");
        }

        if(s.length() == 1){
            return toNumber(s.charAt(0));
        }else {
            int ret = toNumber(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                if (toNumber(s.charAt(i - 1)) < toNumber(s.charAt(i))) {
                    //这边考虑了 不会出现错误的罗马数字 比如MCMLXXX 的情况 但是没有对罗马数据规范做检查
                    ret += toNumber(s.charAt(i)) - 2*toNumber(s.charAt(i - 1));
                } else {
                    ret += toNumber(s.charAt(i));
                }
            }
            return ret;
        }

    }

    public static int toNumber(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new RuntimeException("wrong roman number");
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMLXXX"));
    }


}
