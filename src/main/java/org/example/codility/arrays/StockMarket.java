package org.example.codility.arrays;

/**
 * 给定一个股票价格数组，计算最大利润（只能买卖一次）。
 *
 * 输入：int[] prices = {7, 1, 5, 3, 6, 4}
 * 输出：最大利润为 5（在价格为 1 时买入，价格为 6 时卖出）
 */
public class StockMarket {

    public static int solution(int[] arr) {
        int max = 0;
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i] - min);
        }
        return max;
    }
}
