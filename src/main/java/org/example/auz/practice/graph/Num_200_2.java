package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 200. Number of Islands
 * <p>
 * https://leetcode.com/problems/number-of-islands/description/?show=1
 *
 * bfs
 */
public class Num_200_2 {

    public int numIslands(char[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    void bfs(char[][] grid, int i, int j) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;

                if (newX >= 0 && newX < grid.length
                        && newY >= 0 && newY < grid[0].length
                        && grid[newX][newY] == '1') {
                    grid[newX][newY] = '0';
                    q.addLast(new int[]{newX, newY});
                }
            }
        }
    }

}
