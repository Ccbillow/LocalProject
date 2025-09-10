package org.example.auz.practice.backtrack;

/**
 * 1219. path-with-maximum-gold
 * https://leetcode.cn/problems/path-with-maximum-gold/description/?show=1
 */
public class Num_1219_1 {

    int m, n;
    boolean[][] visited;
    int res = 0;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y, int sum) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] == 0) {
            return;
        }
        if (visited[x][y]) {
            return;
        }

        sum = sum + grid[x][y];
        res = Math.max(res, sum);

        visited[x][y] = true;
        dfs(grid, x + 1, y, sum);
        dfs(grid, x - 1, y, sum);
        dfs(grid, x, y + 1, sum);
        dfs(grid, x, y - 1, sum);
        visited[x][y] = false;
    }
}
