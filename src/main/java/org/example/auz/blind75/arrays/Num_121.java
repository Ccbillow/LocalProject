package org.example.auz.blind75.arrays;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * time : O(n)
 * space : O(1)
 */
public class Num_121 {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            if (min > price) {
                min = price;
            }
            max = Math.max(max , price - min);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arrs = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arrs));
    }
}
