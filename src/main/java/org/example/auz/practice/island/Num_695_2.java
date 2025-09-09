package org.example.auz.practice.island;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 695. Max Area of Island
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class Num_695_2 {

    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res,  bfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{i, j});
        grid[i][j] = 0;

        int area = 0;

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];
            area++;

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < grid.length
                        && newY >= 0 && newY < grid[0].length
                        && grid[newX][newY] == 1) {
                    q.addLast(new int[]{newX, newY});
                    grid[newX][newY] = 0;
                }
            }
        }
        return area;
    }


}
