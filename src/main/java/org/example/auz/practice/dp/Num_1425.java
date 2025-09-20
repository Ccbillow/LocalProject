package org.example.auz.practice.dp;

/**
 * 1425. constrained-subsequence-sum
 *
 * https://leetcode.cn/problems/constrained-subsequence-sum/description/?show=1
 */
public class Num_1425 {

    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];

            for (int j = i - k; j < i; j++) {
                if (i - k < 0) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
