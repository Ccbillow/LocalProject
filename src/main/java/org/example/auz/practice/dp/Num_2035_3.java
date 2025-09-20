package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2035. partition-array-into-two-arrays-to-minimize-sum-difference
 * https://leetcode.cn/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/
 */
public class Num_2035_3 {

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        int target = sum / 2;

        int[][] dp = new int[n / 2 + 1][target + 1];
        for (int i = 0; i <= n / 2; i++) {
            Arrays.fill(dp[i], -1); // -1 表示不可达
        }

        dp[0][0] = 0;

        for (int num : nums) {
            for (int i = n / 2; i >= 1; i--) {
                for (int j = target; j >= num; j--) {
                    if (dp[i - 1][j - num] != -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - num] + num);
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j <= target; j++) {
            if (dp[n / 2][j] != -1) {
                res = Math.max(res, dp[n / 2][j]);
            }
        }
        return Math.abs(sum - 2 * res);
    }

}
