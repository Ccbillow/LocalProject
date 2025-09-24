package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * maximum-total-reward-using-operations-i
 * https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/?show=1
 */
public class Num_3180_3 {


    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);

        int n = rewardValues.length;
        int sum = Arrays.stream(rewardValues).sum();

        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;


        for (int i = 1; i <= n; i++) {
            int val = rewardValues[i - 1];

            for (int j = 0; j <= sum; j++) {

                //不选
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }

                //选
                if (j + val <= sum && dp[i - 1][j] && val > j) {
                    dp[i][val + j] = true;
                }
            }
        }

        for (int j = sum; j >= 0; j--) {
            if (dp[n][j]) return j;
        }

        return 0;
    }

}
