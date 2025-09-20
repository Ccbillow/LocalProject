package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 646. maximum-length-of-pair-chain
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/description/
 */
public class Num_646_2 {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
