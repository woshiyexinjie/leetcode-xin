package com.helloxin.leetcode.algorithms;

/**
 * Created by nandiexin on 2018/12/17.
 *
 You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

 Example:

 Input: 4
 Output: false
 Explanation: If there are 4 stones in the heap, then you will never win the game;
 No matter 1, 2, or 3 stones you remove, the last stone will always be
 removed by your friend.
 */
public class NimGame292 {


    //这不是做数学题吗 每个人可以取 1-3个 那么我们可以看这个数对4进行取余 是多少就可以判断 先抓的可不可以赢
    public boolean canWinNim(int n) {
        int remainder = n %4;
        if(remainder ==0){
            return false;
        }else{
            return true;
        }

    }
}
