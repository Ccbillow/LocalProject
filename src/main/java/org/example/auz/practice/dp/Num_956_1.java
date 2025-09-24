package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 956. tallest-billboard
 * https://leetcode.cn/problems/tallest-billboard/description/
 */
public class Num_956_1 {

    int res = 0;

    public int tallestBillboard(int[] rods) {
        int sum = Arrays.stream(rods).sum();

        dfs(rods, sum, 0, 0, 0);
        return res;
    }

    private void dfs(int[] rods, int sum, int idx, int left, int right) {
        if (idx == rods.length) {
            if (left == right) {
                res = Math.max(res, left);
            }
            return;
        }

        if (Math.abs(left - right) > sum) {
            return;
        }

        int rod = rods[idx];
        dfs(rods, sum - rod, idx + 1, left + rod, right);
        dfs(rods, sum - rod, idx + 1, left, right + rod);
        dfs(rods, sum - rod, idx + 1, left, right);
    }

}
