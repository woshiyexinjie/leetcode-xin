package com.helloxin.leetcode.algorithms;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.

 */

/**
 * Created by nandiexin on 2018/3/12.
 */
public class BestTimeToBuyAndSellStock {


    //写个简单的方法， 所有遍历一遍 就是会有这个问题Time Limit Exceeded
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        if (null != prices  && prices.length != 0){
            for (int i = 0 ; i < prices.length;i++){
                int submMaxProfit = 0;
                int difference = submMaxProfit;
                for (int j = i+1;j <prices.length;j++ ){
                     difference = prices[j]-prices[i];
                     if(difference > submMaxProfit){
                         submMaxProfit = difference;
                     }
                }
                if(maxProfit < submMaxProfit){
                    maxProfit = submMaxProfit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {

        int le = prices.length, maxD = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < le; i++){
            min = Math.min(min, prices[i]);
            maxD = Math.max(maxD, prices[i] - min);
        }

        return maxD;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices ={7, 1, 5, 3, 6, 4};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
        prices = new int[] {2,3,4,3,2,1};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }
}
