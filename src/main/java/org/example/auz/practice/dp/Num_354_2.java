package org.example.auz.practice.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. Russian Doll Envelopes
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 */
public class Num_354_2 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int idx = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (idx < 0) {
                idx = -(idx + 1);
                dp[idx] = envelope[1];
                if (idx == len) {
                    len++;
                }
            }
        }
        return len;
    }


}
