package org.example.auz.practice.graph;

/**
 * 1020. Number of Enclaves
 * https://leetcode.com/problems/number-of-enclaves/description/
 */
public class Num_1020_1 {

    int m, n;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = count + dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
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

    public static void main(String[] args) {
        Num_1020_1 test = new Num_1020_1();
        int[][] grid = {{0, 0, 0, 0},
                        {1, 0, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}};
        test.numEnclaves(grid);
    }
}
