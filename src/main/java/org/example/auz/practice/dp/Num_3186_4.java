package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 3186. maximum-total-damage-with-spell-casting
 * https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/
 */
public class Num_3186_4 {

    public long maximumTotalDamage(int[] power) {
        int max = Arrays.stream(power).max().getAsInt();
        long[] dp = new long[max + 1];
        long[] cnt = new long[max + 1];
        for (int p : power) {
            cnt[p]++;
        }

        for (int i = 1; i <= max; i++) {
            long take = (i >= 3 ? dp[i - 3] : 0) + i * cnt[i];
            long skip1 = (i >= 2 ? dp[i - 2] : 0);
            long skip2 = (i >= 1 ? dp[i - 1] : 0);
            dp[i] = Math.max(take, Math.max(skip1, skip2));
        }

        return dp[max];
    }
}
