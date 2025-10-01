package org.example.auz.practice.dp;

/**
 * 2320. count-number-of-ways-to-place-houses
 * https://leetcode.cn/problems/count-number-of-ways-to-place-houses/description/
 */
public class Num_2320_3 {

    public int countHousePlacements(int n) {
        int mod = 1_000_000_007;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        return (int) ((long) dp[n] * dp[n] % mod);
    }
}
