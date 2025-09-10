package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1091. shortest-path-in-binary-matrix
 * https://leetcode.cn/problems/shortest-path-in-binary-matrix/description/?show=1
 */
public class Num_1091_2 {


    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});
        visited[0][0] = true;

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.removeFirst();
                int x = cur[0];
                int y = cur[1];

                if (x == m - 1 && y == n - 1) {
                    return res;
                }

                for (int[] dir : dirs) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                        if (!visited[newx][newy] && grid[newx][newy] != 1) {
                            visited[newx][newy] = true;
                            q.addLast(new int[]{newx, newy});
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
