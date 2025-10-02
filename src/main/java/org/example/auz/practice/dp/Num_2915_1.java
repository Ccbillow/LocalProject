package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.List;

/**
 * 2915. length-of-the-longest-subsequence-that-sums-to-target
 * https://leetcode.cn/problems/length-of-the-longest-subsequence-that-sums-to-target/description/
 */
public class Num_2915_1 {

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();

        int[][] dp = new int[n + 1][target + 1];
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int num = nums.get(i);

            for (int j = 1; j <= target; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + 1);
                }
            }
        }
        return dp[n][target] > 0 ? dp[n][target] : -1;
    }
}
