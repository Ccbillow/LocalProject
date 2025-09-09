package org.example.auz.practice.island;

/**
 * LCR 105. 岛屿的最大面积
 * https://leetcode.cn/problems/ZL6zAn/description/?show=1
 */
public class LCR_105 {

    int m, n;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }

        if (grid[x][y] == 0) {
            return 0;
        }

        if (visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        return 1 + dfs(grid, x + 1, y)
                + dfs(grid, x - 1, y)
                + dfs(grid, x, y - 1)
                + dfs(grid, x, y + 1);
    }
}
