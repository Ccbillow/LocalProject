package org.example.auz.practice.island;

/**
 * 1905. count-sub-islands
 *
 * https://leetcode.cn/problems/count-sub-islands/description/
 */
public class Num_1905 {
    int m, n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] == 0 || grid[x][y] == 2) {
            return;
        }

        grid[x][y] = 2;

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
