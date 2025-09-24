package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * greatest-sum-divisible-by-three
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/description/?show=1
 */
public class Num_1262_2 {

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][3];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            int mod = num % 3;

            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            for (int j = 0; j < 3; j++) {
                if (dp[i - 1][j] == Integer.MIN_VALUE) {
                    continue;
                }

                int nj = (j + mod) % 3;
                dp[i][nj] = Math.max(dp[i][nj], dp[i - 1][j] + num);
            }
        }

        return dp[n][0];
    }
}
