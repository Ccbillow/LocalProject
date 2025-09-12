package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 994. rotting-oranges
 * https://leetcode.cn/problems/rotting-oranges/description/?show=1
 */
public class Num_994_2 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.addLast(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int res = -1;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.removeFirst();
                int curx = cur[0];
                int cury = cur[1];

                for (int[] dir : dirs) {
                    int x = curx + dir[0];
                    int y = cury + dir[1];

                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (visited[x][y]) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            q.addLast(new int[]{x, y});
                            visited[x][y] = true;
                            fresh--;
                        }
                    }
                }
            }
            res++;
        }

        return fresh == 0 ? res : -1;
    }
}
