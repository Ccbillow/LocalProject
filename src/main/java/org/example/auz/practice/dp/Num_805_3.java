package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 805. split-array-with-same-average
 * https://leetcode.cn/problems/split-array-with-same-average/description/
 */
public class Num_805_3 {


    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        boolean[][] dp = new boolean[sum + 1][n / 2 + 1];

        dp[0][0] = true;

        for (int num: nums) {
            for (int i = sum; i >= num; i--) {
                for (int j = 1; j <= n / 2; j++) {
                    dp[i][j] |= dp[i - num][j - 1];
                }
            }
        }

        for (int j = 1; j <= n / 2; j++) {
            if ((sum * j) % n == 0 && dp[sum * j / n][j]) {
                return true;
            }
        }
        return false;
    }



}
