package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 474. ones-and-zeroes
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 */
public class Num_474_3 {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        return dfs(strs, m, n, len - 1);
    }

    private int dfs(String[] strs, int m, int n, int i) {
        if (i < 0 || m < 0 || n < 0) {
            return 0;
        }

        String str = strs[i];
        int zero = 0;
        int one = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') zero++;
            if (c == '1') one++;
        }

        int res = dfs(strs, m, n, i - 1);
        if (m >= zero && n >= one) {
            res = Math.max(res, dfs(strs, m - zero, n - one, i - 1) + 1);
        }

        return res;
    }


}
