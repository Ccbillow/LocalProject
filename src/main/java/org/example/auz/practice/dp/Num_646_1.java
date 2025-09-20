package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 646. maximum-length-of-pair-chain
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/description/
 */
public class Num_646_1 {

    // 1,3  2,5  4,6  7,9
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int res = 0;
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < pairs.length; i++) {
            if (prev < pairs[i][0]) {
                prev = pairs[i][1];
                res++;
            }
        }
        return res;
    }
}
