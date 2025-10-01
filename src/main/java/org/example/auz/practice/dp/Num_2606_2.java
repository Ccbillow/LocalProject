package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2606. find-the-substring-with-maximum-cost
 * https://leetcode.cn/problems/find-the-substring-with-maximum-cost/description/
 */
public class Num_2606_2 {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n = s.length();

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);

            int val;
            int idx = chars.indexOf(c);
            if (idx == -1) {
                val = c - 'a' + 1;
            } else {
                val = vals[idx];
            }

            preSum[i] = preSum[i - 1] + val;
        }

        int min = 0;
        int res = Integer.MIN_VALUE;
        for (int p : preSum) {
            res = Math.max(res, p - min);
            min = Math.min(min, p);
        }

        return res;
    }

}
