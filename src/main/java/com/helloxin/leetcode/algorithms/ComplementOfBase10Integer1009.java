package com.helloxin.leetcode.algorithms;

/**
 * Created by yexin on 2019/10/15.
 * Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.
 * <p>
 * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.
 * <p>
 * For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * Example 2:
 * <p>
 * Input: 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * Example 3:
 * <p>
 * Input: 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= N < 10^9
 */
public class ComplementOfBase10Integer1009 {
    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) {
            X = X * 2 + 1;
        }
        return X - N;
    }

    public int bitwiseComplement2(int N) {
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return 0;
        }
        int x = 1;
        while(x<= N){
            x = x << 1;  // equialently written as x*=2;
        }
        return N ^ (x-1);
    }

    public static int bitwiseComplement3(int N) {
        String str = Integer.toString(N,2);
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < str.length(); i++){
            if(str.charAt(i) =='0'){
                sb.append(1);}
            if(str.charAt(i) == '1'){
                sb.append(0);}
        }
        String nw = sb.toString();

        int result = Integer.parseInt(nw,2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement3(9));
    }
}
