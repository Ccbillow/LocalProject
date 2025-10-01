package org.example.auz.practice.dp;

/**
 * 152. maximum-product-subarray
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 */
public class Num_152_1 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = nums[0];
        dp[1][1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][0] * nums[i - 1], dp[i - 1][1] * nums[i - 1]));
            dp[i][1] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][0] * nums[i - 1], dp[i - 1][1] * nums[i - 1]));
        }

        int res = Integer.MIN_VALUE;
        for (int[] d : dp) {
            res = Math.max(res, d[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        Num_152_1 test = new Num_152_1();
        int[] arr = {-2};
        test.maxProduct(arr);
    }
}
