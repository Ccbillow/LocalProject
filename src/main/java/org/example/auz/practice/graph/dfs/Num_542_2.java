package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/description/?show=1
 */
public class Num_542_2 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.addLast(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.removeLast();
            int x = cur[0];
            int y = cur[1];
            int d = dist[x][y];

            for (int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];
                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    if (dist[newx][newy] == -1 || d + 1 < dist[newx][newy]) {
                        dist[newx][newy] = d + 1;
                        q.addLast(new int[]{newx, newy});
                    }
                }
            }
        }

        return dist;
    }
}
