package org.example.auz.practice.graph.dfs;

import java.util.Arrays;

/**
 * 1926. Nearest Exit from Entrance in Maze
 * https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/?show=1
 */
public class Num_1926_3 {

    int m, n;

    boolean[][] visited;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int min = Integer.MAX_VALUE;

    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n];

        dfs(maze, entrance[0], entrance[1], 0, entrance);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(char[][] maze, int x, int y, int step, int[] entrance) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (maze[x][y] == '+') {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        if (!(x == entrance[0] && y == entrance[1])
                && (x == 0 || x == m - 1 || y == 0 || y == n - 1)) {
            min = Math.min(min, step);
            return;
        }

        visited[x][y] = true;
        for (int[] dir : dirs) {
            dfs(maze, x + dir[0], y + dir[1], step + 1, entrance);
        }
        visited[x][y] = false;
    }
}
