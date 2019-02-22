package com.helloxin.leetcode.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nandiexin on 2019/2/22.
 For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

 1. The area of the rectangular web page you designed must equal to the given target area.

 2. The width W should not be larger than the length L, which means L >= W.

 3. The difference between length L and width W should be as small as possible.
 You need to output the length L and the width W of the web page you designed in sequence.
 Example:
 Input: 4
 Output: [2, 2]
 Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
 But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 Note:
 The given area won't exceed 10,000,000 and is a positive integer
 The web page's width and length you designed must be positive integers.
 *
 *
 */
public class ConstructTheRectangle492 {

    //开始我想这是找一个数的因素有哪些
    //哎 这个方法提示 	Time Limit Exceeded
    //方法实现了 再抽象的能力
    public static int[] constructRectangle(int area) {

        double sqrt = Math.sqrt(area);
        long base = Double.valueOf(sqrt).longValue()+1L;
        for (long i=base;i>=2;i--){
              for(long j=base-1;j<area;j++){
                   if(i*j == area){
                       //这里好像也是没必要的吧
                       if(i<j) {
                           return new int[]{(int)j, (int)i};
                       }else{
                           return new int[]{(int)i, (int)j};
                       }
                   }
              }
        }
        return new int[]{area,1};
    }

    //是我写复杂了 还有取余这种操作
    public static int[] constructRectangle2(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) {
            w--;
        }
        return new int[]{area/w, w};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(constructRectangle2(3)));
    }
}
