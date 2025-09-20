package org.example.auz.practice.dp;

/**
 * 416. partition-equal-subset-sum
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class Num_416_1 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // 前i个数，能不能组成0。都不选，可以组成0，所以初始化true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 如果 j < nums[i - 1], 只能不选i
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选或不选
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}
