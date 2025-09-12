package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1765. Map of Highest Peak
 * https://leetcode.com/problems/map-of-highest-peak/description/
 */
public class Num_1765 {

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 0) {
                    q.addLast(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    if (dist[newx][newy] == -1) {
                        dist[newx][newy] = dist[x][y] + 1;
                        q.addLast(new int[]{newx, newy});
                    }
                }
            }
        }
        return dist;
    }
}
