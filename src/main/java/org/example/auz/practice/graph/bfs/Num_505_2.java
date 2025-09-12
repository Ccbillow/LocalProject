package org.example.auz.practice.graph.bfs;

import java.util.Arrays;

/**
 * The Maze II
 */
public class Num_505_2 {

    int m, n;
    int[][] dist;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;

        dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dfs(maze, start[0], start[1]);

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int x, int y) {
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
                dfs(maze, newx, newy);
            }
        }
    }
}
