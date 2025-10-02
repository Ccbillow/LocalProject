package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 3181. maximum-total-reward-using-operations-ii
 * https://leetcode.cn/problems/maximum-total-reward-using-operations-ii/description/
 */
public class Num_3181 {

    public int maxTotalReward(int[] rewardValues) {
        int[] nums = Arrays.stream(rewardValues).distinct().sorted().toArray();

        int m = nums.length;
        int n = 2 * nums[m - 1];

        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            int num = nums[i - 1];

            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j - num >= 0 && num > (j - num)) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }

        for (int j = n; j >= 0; j--) {
            if (dp[m][j]) return j;
        }

        return 0;
    }

}
