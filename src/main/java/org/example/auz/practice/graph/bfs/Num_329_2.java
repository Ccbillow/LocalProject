package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 329. longest-increasing-path-in-a-matrix
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/description/?show=1
 */
public class Num_329_2 {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, bfs(matrix, i, j));
            }
        }
        return res;
    }

    int bfs(int[][] matrix, int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{i, j});

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int[] cur = q.removeFirst();
                int x = cur[0];
                int y = cur[1];

                for (int[] dir : dirs) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                        if (matrix[newx][newy] > matrix[x][y]) {
                            q.addLast(new int[]{newx, newy});
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }
}
