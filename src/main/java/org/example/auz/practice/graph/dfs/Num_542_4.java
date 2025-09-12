package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/description/?show=1
 */
public class Num_542_4 {

    int m, n;
    int[][] dist;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    dfs(mat, i, j, 0);
                }
            }
        }
        return dist;
    }

    private void dfs(int[][] mat, int x, int y, int step) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (step > dist[x][y]) {
            return;
        }

        dist[x][y] = step;

        for (int[] dir : dirs) {
            dfs(mat, x + dir[0], y + dir[1], step + 1);
        }
    }
}
