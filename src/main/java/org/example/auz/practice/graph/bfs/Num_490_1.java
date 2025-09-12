package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The Maze
 */
public class Num_490_1 {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{start[0], start[1]});
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.removeFirst();
                int x = cur[0];
                int y = cur[1];

                if (x == destination[0] && y == destination[1]) {
                    return true;
                }

                for (int[] dir : dirs) {
                    int newx = cur[0];
                    int newy = cur[1];

                    while (newx + dir[0] >= 0 && newx + dir[0] < m
                            && newy + dir[1] >= 0 && newy + dir[1] < n
                            && maze[newx + dir[0]][newy + dir[1]] == 0) {
                        newx = newx + dir[0];
                        newy = newy + dir[1];
                    }
                    if (!visited[newx][newy]) {
                        visited[newx][newy] = true;
                        q.add(new int[]{newx, newy});
                    }
                }
            }
        }
        return false;
    }
}
