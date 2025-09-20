package org.example.auz.practice.dp;

/**
 * 416. partition-equal-subset-sum
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class Num_416_2 {

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
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
