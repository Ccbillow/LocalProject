package org.example.auz.practice.backtrack;

/**
 * 1219. path-with-maximum-gold
 * https://leetcode.cn/problems/path-with-maximum-gold/description/?show=1
 */
public class Num_1219 {

    int m, n;
    boolean[][] onPath;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int res = 0;


    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        onPath = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y, int pathSum) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] == 0) {
            return;
        }

        if (onPath[x][y]) {
            return;
        }

        onPath[x][y] = true;
        pathSum = pathSum + grid[x][y];

        res = Math.max(res, pathSum);

        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            dfs(grid, newx, newy, pathSum);
        }
    }
}
