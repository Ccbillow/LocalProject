package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num_994 {

    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.addLast(new int[]{i, j});
                }
            }
        }


        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                int[] cur = q.removeFirst();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        q.addLast(new int[]{newX, newY});
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] ==1) {
                    return -1;
                }
            }
        }

        return count == 0 ? 0 : count - 1;
    }


}
