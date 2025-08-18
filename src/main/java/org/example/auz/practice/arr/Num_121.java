package org.example.auz.practice.arr;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class Num_121 {

    public int maxProfit(int[] prices) {
        int profit = prices[0];
        int max = 0;

        for (int price : prices) {
            if (price < profit) {
                profit = price;
            }
            max = Math.max(max, price - profit);
        }
        return max;
    }
}
