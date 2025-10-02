package org.example.auz.practice.dp;

/**
 * 2787. ways-to-express-an-integer-as-sum-of-powers
 * https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/description/
 */
public class Num_2787_1 {

    int mod = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        long res = dfs(n, n, x);
        return (int) (res % mod);
    }

    private long dfs(int i, int j, int x) {
        if (j == 0) {
            return 1;
        }

        if (i == 0 || j < 0) {
            return 0;
        }

        long res = dfs(i - 1, j, x);

        int pow = (int) Math.pow(i, x);
        if (j >= pow) {
            res += dfs(i - 1, j - pow, x);
        }
        return res;
    }
}
