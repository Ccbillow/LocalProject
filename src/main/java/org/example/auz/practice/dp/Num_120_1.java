package org.example.auz.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. triangle
 * https://leetcode.cn/problems/triangle/description/
 */
public class Num_120_1 {

    int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        return memo[i][j] = triangle.get(i).get(j) + Math.min(
                dfs(triangle, i + 1, j),
                dfs(triangle, i + 1, j + 1));
    }
}
