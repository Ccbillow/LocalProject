package org.example.auz.practice.dp;

/**
 * 2320. count-number-of-ways-to-place-houses
 * https://leetcode.cn/problems/count-number-of-ways-to-place-houses/description/
 */
public class Num_2320_1 {

    int mod = 1_000_000_007;

    public int countHousePlacements(int n) {
        return (dfs(n, 0) * dfs(n, 0)) % mod;
    }

    private int dfs(int n, int i) {
        if (i >= n) {
            return 1;
        }
        return (dfs(n, i + 1) + dfs(n, i + 2)) % mod;
    }
}
