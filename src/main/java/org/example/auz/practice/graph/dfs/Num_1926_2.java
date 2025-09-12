package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1926. Nearest Exit from Entrance in Maze
 * https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/?show=1
 */
public class Num_1926_2 {

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[entrance[0]][entrance[1]] = 0;

        Deque<int[]> stack = new ArrayDeque<>();
        stack.add(new int[]{entrance[0], entrance[1], 0});

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int min = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            int[] cur = stack.removeLast();
            int x = cur[0];
            int y = cur[1];
            int step = cur[2];

            if ((x != entrance[0] || y != entrance[1])
                    && (x == 0 || x == m - 1 || y == 0 || y == n - 1)) {
                min = Math.min(min, step);
                continue;
            }

            for (int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    if (maze[newx][newy] == '+') {
                        continue;
                    }

                    if (step + 1 < dist[newx][newy]) {
                        stack.addLast(new int[]{newx, newy, step + 1});
                        dist[newx][newy] = step + 1;
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
