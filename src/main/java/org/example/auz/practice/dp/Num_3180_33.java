package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * maximum-total-reward-using-operations-i
 * https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/?show=1
 */
public class Num_3180_33 {


    public int maxTotalReward(int[] rewardValues) {
        int[] nums = Arrays.stream(rewardValues).distinct().sorted().toArray();

        int m = nums.length;
        int n = 2 * nums[m - 1];

        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            int num = nums[i - 1];

            for (int j = 1; j <= n; j++) {
                if (j < num || (j - num) >= num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }

        for (int j = n; j >= 0; j--) {
            if (dp[m][j]) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Num_3180_33 test = new Num_3180_33();
        int[] arr = {1, 6, 4, 3, 2};
        System.out.println(test.maxTotalReward(arr));
    }


}
