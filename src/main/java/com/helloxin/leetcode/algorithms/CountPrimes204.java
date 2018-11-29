package com.helloxin.leetcode.algorithms;

import java.util.Arrays;

/**
 * Created by nandiexin on 2018/11/28.
 Count the number of prime numbers less than a non-negative number, n.

 Example:

 Input: 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
public class CountPrimes204 {

    //想先用粗暴的方法实现一下
    public static int countPrimes(int n) {

        int count = 0;
        for(int i = 1;i<n;i++){
            if(isPrime(i)){
               count ++;
            }
        }
        return count;

    }

    //全部判断一下是否书素数 但是这看到有是那个循环 时间复杂度接受不了
    private static boolean isPrime(int i) {

        if(i ==1){
            return false;
        }
        for(int j =2;j< i;j++){
            for(int j2 =2;j2< i;j2++){
                 if(j*j2 == i){
                     return false;
                 }
            }
        }
        return true;

    }

    //如果稍微优化一下呢 结果还是超时
    public static boolean isPrime2(int i) {

        if(i ==1 ){
            return false;
        }
        //这样是否可以快点去掉一些数据
        if(i > 10 && (i%2==0 ||i%3==0||i%5==0||i%7==0)){
            return false;
        }
        for(int j =2;j< Math.sqrt(i)+1;j++){
            int j2 = (int)(Math.sqrt(i)) > 2?  (int)(Math.sqrt(i)):2;
            for(; j2< i; j2++){
                if(j*j2 == i){
                    return false;
                }
            }
        }
        return true;

    }

    /**
      这里的想法是反一下 找出所有的合数
     */
    public static int countPrimes2(int n) {

        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }


    //这里用了不断累加的方法 感觉也不错
    public static  int countPrimes3(int n) {

        boolean[] m = new boolean[n];
        int count = 0;
        for (int i=2; i<n; i++) {
            if (m[i]) {
                continue;
            }
            count++;
            for (int j=i; j<n; j=j+i) {
                m[j] = true;
            }
        }

        return count;

    }


    public static void main(String[] args) {

        System.out.println(countPrimes3(10));
    }
}
