package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 2320. count-number-of-ways-to-place-houses
 * https://leetcode.cn/problems/count-number-of-ways-to-place-houses/description/
 */
public class Num_2320_2 {

    int[] memo;
    int mod = 1_000_000_007;

    public int countHousePlacements(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int res = dfs(n, 0);
        return (int) ((long) res * res % mod);
    }

    private int dfs(int n, int i) {
        if (i >= n) {
            return 1;
        }

        if (memo[i] != -1) {
            return memo[i];
        }
        return memo[i] = (dfs(n, i + 1) + dfs(n, i + 2)) % mod;
    }

}
