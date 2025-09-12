package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 994. rotting-oranges
 * https://leetcode.cn/problems/rotting-oranges/description/?show=1
 */
public class Num_994_4 {


    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    Deque<int[]> stack = new ArrayDeque<>();
                    stack.addLast(new int[]{i, j, 0});

                    while (!stack.isEmpty()) {
                        int[] cur = stack.removeLast();
                        int x = cur[0];
                        int y = cur[1];
                        int step = cur[2];

                        for (int[] dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];

                            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                if (grid[nx][ny] == 0) {
                                    continue;
                                }

                                if (step + 1 < dist[nx][ny]) {
                                    dist[nx][ny] = step + 1;
                                    stack.addLast(new int[]{nx, ny, step + 1});
                                }
                            }
                        }
                    }
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


}
