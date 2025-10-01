package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3186. maximum-total-damage-with-spell-casting
 * https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/
 */
public class Num_3186_2 {

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> val2Count = new HashMap<>();
        for (int p : power) {
            val2Count.put(p, val2Count.getOrDefault(p, 0) + 1);
        }

        int n = val2Count.size();
        int[] arr = new int[n];
        int idx = 0;
        for (Integer val : val2Count.keySet()) {
            arr[idx] = val;
            idx++;
        }
        Arrays.sort(arr);

        long[] dp = new long[n + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];

            while (arr[j] < cur - 2) {
                j++;
            }

            dp[i + 1] = Math.max(dp[i], dp[j] + (long) cur * val2Count.get(cur));
        }
        return dp[n];
    }
}
