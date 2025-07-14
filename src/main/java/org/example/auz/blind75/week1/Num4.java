package org.example.auz.blind75.week1;

/**
 * Best Time to Buy and Sell Stock
 *
 */
public class Num4 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int num = prices[0];
        for (int i = 1; i < prices.length; i++) {
            num = Math.min(num, prices[i]);
            profit = Math.max(profit, prices[i] - num);
        }

        return profit;
    }

}
