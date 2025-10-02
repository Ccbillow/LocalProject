package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 494. target-sum
 * https://leetcode.cn/problems/target-sum/description/
 */
public class Num_494_3 {


    // sumA - sumB = target
    // -> sumA = target + sumB
    // -> sumA + sumA = target + sumA + sumB
    // -> 2 * sumA = sum + target
    // -> sumA = (sum + target) / 2
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum - Math.abs(target) < 0 || (sum + target) % 2 == 1) {
            return 0;
        }

        int m = (sum + target) / 2;

        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][m];
    }


}
