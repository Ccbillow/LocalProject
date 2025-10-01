package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 *
 * 2466. count-ways-to-build-good-stringsq
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/description/
 */
public class Num_2466_2 {

    int mod = 1_000_000_007;

    int[] memo;

    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high + 1];
        Arrays.fill(memo, -1);

        int res = 0;

        for (int i = low; i <= high; i++) {
            res = (res + dfs(i, zero, one)) % mod;
        }
        return res;
    }

    private int dfs(int i, int zero, int one) {
        if (i == 0) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        return memo[i] = (dfs(i - zero, zero, one) + dfs(i - one, zero, one)) % mod;
    }


}
