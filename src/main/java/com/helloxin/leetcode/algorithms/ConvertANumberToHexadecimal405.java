package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/1/11.

 Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

 Note:

 All letters in hexadecimal (a-f) must be in lowercase.
 The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 The given number is guaranteed to fit within the range of a 32-bit signed integer.
 You must not use any method provided by the library which converts/formats the number to hex directly.
 Example 1:

 Input:
 26

 Output:
 "1a"
 Example 2:

 Input:
 -1

 Output:
 "ffffffff"
 */
public class ConvertANumberToHexadecimal405 {

    public static  String toHex(int num) {

        //这样搞不定负数呀 题目的意思真奇怪哈  -1 ? ffffffff
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
//        StringBuilder result = new StringBuilder();
//        int tenNum = num;
//        while(tenNum > 0 ){
//
//            int rest = tenNum%16;
//            result.append(map[rest]);
//            tenNum = tenNum/16;
//        }
//
//        return result.reverse().toString();

        if(num == 0) {
            return "0";
        }
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

    public String toHex2(int dec) {
        if (dec == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();

        while (dec != 0) {
            int digit = dec & 0xf;
            res.append(digit < 10 ? (char)(digit + '0') : (char)(digit - 10 + 'a'));
            dec >>>= 4;
        }

        return res.reverse().toString();
    }


    public static void main(String[] args) {

        System.out.println(toHex(-1));

    }
}
