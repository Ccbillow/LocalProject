package org.example.auz.blind75.map;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 542. 01 Matrix
 * https://leetcode.com/problems/01-matrix/description/
 */
public class Num_542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    deque.addLast(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && mat[nx][ny] == -1) {
                    mat[nx][ny] = mat[x][y] + 1;
                    deque.addLast(new int[]{nx, ny});
                }
            }
        }
        return mat;
    }
}
