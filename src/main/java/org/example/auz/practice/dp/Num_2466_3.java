package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 *
 * 2466. count-ways-to-build-good-stringsq
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/description/
 */
public class Num_2466_3 {



    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;

        int[] dp = new int[high + 1];
        dp[0] = 1;

        int res = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) dp[i] = (dp[i] + dp[i - zero]) % mod;
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % mod;

            if (i >= low) {
                res = (res + dp[i]) % mod;
            }
        }

        return res;
    }

}
