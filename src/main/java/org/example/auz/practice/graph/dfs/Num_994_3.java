package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 994. rotting-oranges
 * https://leetcode.cn/problems/rotting-oranges/description/?show=1
 */
public class Num_994_3 {

    int m, n;

    int[][] dist;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 0);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (dist[i][j] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    res = Math.max(res, dist[i][j]);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y, int step) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] == 0) {
            return;
        }

        if (step >= dist[x][y]) {
            return;
        }

        dist[x][y] = step;

        for (int[] dir : dirs) {
            dfs(grid, x + dir[0], y + dir[1], step + 1);
        }
    }
}
