package org.example.codility.math;

/**
 * 某股票每天的价格记录在数组中，编写函数返回最大可能利润（允许多次买卖，但不能同时持有多股）。
 */
public class StockProfit {

    public static int solution(int[] arr) {
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                max = max + arr[i] - arr[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("最大利润: " + solution(prices));  // 输出：7
    }
}
