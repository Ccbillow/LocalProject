package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * The Maze II
 */
public class Num_505_1 {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{start[0], start[1]});
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int newx = x;
                int newy = y;
                int d = dist[x][y];

                while (newx + dir[0] >= 0 && newx + dir[0] < m
                        && newy + dir[1] >= 0 && newy + dir[1] < n
                        && maze[newx + dir[0]][newy + dir[1]] == 0) {
                    newx = newx + dir[0];
                    newy = newy + dir[1];
                    d++;
                }
                if (d < dist[newx][newy]) {
                    dist[newx][newy] = d;
                    q.addLast(new int[]{newx, newy});
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}
