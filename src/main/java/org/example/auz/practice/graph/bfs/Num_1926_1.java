package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1926. Nearest Exit from Entrance in Maze
 * https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/?show=1
 */
public class Num_1926_1 {

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{entrance[0], entrance[1]});
        visited[entrance[0]][entrance[1]] = true;

        int res = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.removeFirst();
                int x = cur[0];
                int y = cur[1];

                if (res != 0 && (x == 0 || x == m - 1 || y == 0 || y == n - 1)) {
                    return res;
                }

                for (int[] dir : dirs) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                        if (visited[newx][newy]) {
                            continue;
                        }

                        if (maze[newx][newy] == '+') {
                            continue;
                        }

                        q.add(new int[]{newx, newy});
                        visited[newx][newy] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
