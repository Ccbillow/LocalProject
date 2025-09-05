package org.example.auz.practice.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1091. Shortest Path in Binary Matrix
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 */
public class Num_1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

        int res = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] first = q.removeFirst();
                int x = first[0];
                int y = first[1];

                if (x == m - 1 && y == n - 1) {
                    return res;
                }

                for (int[] dir : dirs) {
                    int newx = dir[0] + x;
                    int newy = dir[1] + y;

                    if (newx >= 0 && newx < m
                            && newy >= 0 && newy < n
                            && grid[newx][newy] == 0) {
                        if (!visited[newx][newy]) {
                            q.addLast(new int[]{newx, newy});
                            visited[newx][newy] = true;
                        }
                    }
                }
            }

            res++;
        }
        return -1;
    }
}
