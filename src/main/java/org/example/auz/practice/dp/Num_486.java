package org.example.auz.practice.dp;

/**
 * 486. predict-the-winner
 * https://leetcode.cn/problems/predict-the-winner/
 */
public class Num_486 {

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][nums.length - 1] > 0;
    }
}
