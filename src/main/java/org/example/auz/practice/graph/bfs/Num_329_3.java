package org.example.auz.practice.graph.bfs;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 329. longest-increasing-path-in-a-matrix
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/description/?show=1
 */
public class Num_329_3 {



    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        PriorityQueue<int[]> nodes = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes.add(new int[]{i, j, matrix[i][j]});
            }
        }

        int[][] f = new int[m][n];
        for (int i = 0; i < n; i++) Arrays.fill(f[i], 1);

        int res = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!nodes.isEmpty()) {
            int[] node = nodes.poll();
            int x = node[0];
            int y = node[1];
            int val = node[2];

            for (int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];
                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    if (matrix[newx][newy] < val) {
                        f[x][y] = Math.max(f[x][y], f[newx][newy] + 1);
                    }
                }
            }
            res = Math.max(res, f[x][y]);
        }
        return res;
    }

}
