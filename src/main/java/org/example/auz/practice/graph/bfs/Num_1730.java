package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1730. Shortest Path to Get Food
 */
public class Num_1730 {

    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int starti = -1, startj = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    starti = i;
                    startj = j;
                    break;
                }
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{starti, startj});
        boolean[][] visited = new boolean[m][n];
        visited[starti][startj] = true;

        int res = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.removeFirst();
                int x = cur[0];
                int y = cur[1];

                if (grid[x][y] == '#') {
                    return res;
                }

                for (int[] dir : dirs) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                        if (visited[newx][newy]) {
                            continue;
                        }
                        if (grid[newx][newy] == 'X') {
                            continue;
                        }

                        visited[newx][newy] = true;
                        q.addLast(new int[]{newx, newy});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
