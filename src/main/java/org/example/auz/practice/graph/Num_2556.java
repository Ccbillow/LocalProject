package org.example.auz.practice.graph;

/**
 * 2556. disconnect-path-in-a-binary-matrix-by-at-most-one-flip
 * https://leetcode.cn/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/description/
 */
public class Num_2556 {

    int m;
    int n;

    public boolean isPossibleToCutPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (!dfs(grid, 0, 0)) {
            return true;
        }

        grid[0][0] = 1;
        return !dfs(grid, 0, 0);
    }

    private boolean dfs(int[][] grid, int x, int y) {
        if (x >= m || y >= n || grid[x][y] == 0) {
            return false;
        }

        if (x == m - 1 && y == n - 1) {
            return true;
        }

        grid[x][y] = 0;
        return dfs(grid, x + 1, y) || dfs(grid, x, y + 1);
    }
}
