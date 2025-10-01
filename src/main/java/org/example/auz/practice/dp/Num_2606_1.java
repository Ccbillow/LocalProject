package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2606. find-the-substring-with-maximum-cost
 * https://leetcode.cn/problems/find-the-substring-with-maximum-cost/description/
 */
public class Num_2606_1 {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);

            int val;
            int idx = chars.indexOf(c);
            if (idx == -1) {
                val = c - 'a' + 1;
            } else {
                val = vals[idx];
            }

            dp[i] = Math.max(val, dp[i - 1] + val);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
