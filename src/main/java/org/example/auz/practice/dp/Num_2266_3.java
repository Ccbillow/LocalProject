package org.example.auz.practice.dp;


/**
 * 2266. count-number-of-texts
 * https://leetcode.cn/problems/count-number-of-texts/description/
 */
public class Num_2266_3 {

    public int countTexts(String pressedKeys) {
        int mod = 1_000_000_007;
        int[] key = {0, 3, 3, 3, 3, 3, 3, 4, 3, 4};

        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int num = pressedKeys.charAt(i - 1) - '0';
            int len = key[num];

            for (int j = 1; j <= len && i - j >= 0; j++) {
                if (pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - j)) {
                    dp[i] = (dp[i] + dp[i - j]) % mod;
                } else {
                    break;
                }
            }
        }

        return dp[n];
    }
}
