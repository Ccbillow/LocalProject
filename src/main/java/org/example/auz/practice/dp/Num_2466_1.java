package org.example.auz.practice.dp;

/**
 *
 * 2466. count-ways-to-build-good-stringsq
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/description/
 */
public class Num_2466_1 {

    int mod = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
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

        return (dfs(i - zero, zero, one) + dfs(i - one, zero, one)) % mod;
    }


}
