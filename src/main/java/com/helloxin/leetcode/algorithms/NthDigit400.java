package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/1/10.
 Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

 Note:
 n is positive and will fit within the range of a 32-bit signed integer (n < 231).

 Example 1:

 Input:
 3

 Output:
 3
 Example 2:

 Input:
 11

 Output:
 0

 Explanation:
 The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
public class NthDigit400 {


    //	Time Limit Exceeded  我想一个个加上去总是可以的吧  但是效率不行
    public static  int findNthDigit(int n) {

        int num = 0;
        for(int i=1;i<=n;i++){
            num += (i+"").length();
            if(num >= n){
                return (i+"").charAt((i+"").length()-num+n-1)-'0';
            }
        }
        return 0;

    }

    //换一个方式 找到那个我要取的数
    public int findNthDigit2(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }


    public static void main(String[] args) {

        System.out.println(findNthDigit(11));

    }

}
