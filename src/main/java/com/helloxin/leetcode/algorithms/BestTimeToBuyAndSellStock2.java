package com.helloxin.leetcode.algorithms;

/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */



/**
 * Created by nandiexin on 2018/10/8.
 */
public class BestTimeToBuyAndSellStock2 {


    public int maxProfit(int[] prices) {

        int le = prices.length, maxD = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int allDeposit = 0;
        boolean change = false;

        for (int i = 0; i < le; i++){

            if(maxD <= prices[i]){
                maxD= prices[i];
            }else{
                allDeposit += maxD - min;
                min = prices[i];
                maxD = prices[i];
            }
            if(min >= prices[i]){
                min = prices[i];
                maxD = prices[i];
            }
            if(i == le-1 && maxD > min){
                allDeposit += maxD - min;
            }
        }
        return allDeposit;

    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;

    }

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();


        int prices[] = {2,4,1};
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit2(prices));
        int prices2[] = {1,2,3,4,5};
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit2(prices2));
        int prices3[] = {7,6,4,3,1};
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit2(prices3));

    }


}
