package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2019/3/29.
 */
public class Bit1andBit2Characters717 {


    public boolean isOneBitCharacter(int[] bits) {


        for (int i = 0; i < bits.length; ) {
            if (i == bits.length - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i += 2;
            } else if (bits[i] == 0) {
                i += 1;
            }
        }

        return false;
    }
}