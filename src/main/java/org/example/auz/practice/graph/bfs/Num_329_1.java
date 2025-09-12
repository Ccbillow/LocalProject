package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 329. longest-increasing-path-in-a-matrix
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/description/?show=1
 */
public class Num_329_1 {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                q.addLast(new int[]{i, j});
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
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
