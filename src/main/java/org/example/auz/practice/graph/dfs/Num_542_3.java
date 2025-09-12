package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/description/?show=1
 */
public class Num_542_3 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    Deque<int[]> stack = new ArrayDeque<>();
                    stack.addLast(new int[]{i, j, 0});
                    while (!stack.isEmpty()) {
                        int[] cur = stack.removeLast();
                        int x = cur[0];
                        int y = cur[1];
                        int d = cur[2];

                        if (d >= dist[x][y]) {
                            continue;
                        }

                        dist[x][y] = d;

                        for (int[] dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                stack.push(new int[]{nx, ny, d + 1});
                            }
                        }
                    }
                }
            }
        }
        return dist;
    }
}
