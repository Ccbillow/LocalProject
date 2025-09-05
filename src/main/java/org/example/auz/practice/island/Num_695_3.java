package org.example.auz.practice.island;

/**
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class Num_695_3 {

    int n;
    int m;

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        return 1 + dfs(grid, i + 1, j)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1);
    }
}
