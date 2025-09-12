package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Walls and Gates
 */
public class Num_286 {

    private static final int INF = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.addLast(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    if (rooms[newx][newy] == INF) {
                        rooms[newx][newy] = rooms[x][y] + 1;
                        q.addLast(new int[]{newx, newy});
                    }
                }
            }
        }
    }
}
