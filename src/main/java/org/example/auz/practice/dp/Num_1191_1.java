package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 1191. k-concatenation-maximum-sum
 * https://leetcode.cn/problems/k-concatenation-maximum-sum/description/
 */
public class Num_1191_1 {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1_000_000_007;

        int n = arr.length;

        int[] nArr = new int[n * k];
        for (int i = 0; i < n * k; i++) {
            int ni = i % n;
            nArr[i] = arr[ni];
        }

        long[] dp = new long[n * k + 1];
        dp[0] = 0;
        for (int i = 1; i <= n * k; i++) {
            long notTake = nArr[i - 1];
            long take = (dp[i - 1] + nArr[i - 1]);
            dp[i] = Math.max(notTake, take);
        }

        return (int) Arrays.stream(dp).max().getAsLong() % mod;
    }
}
