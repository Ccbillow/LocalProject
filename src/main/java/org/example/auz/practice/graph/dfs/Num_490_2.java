package org.example.auz.practice.graph.dfs;

/**
 * The Maze
 */
public class Num_490_2 {

    int m, n;
    boolean[][] visited;
    boolean res = false;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n];
        dfs(maze, start[0], start[1], destination);
        return res;
    }

    void dfs(int[][] maze, int x, int y, int[] destination) {
        if (visited[x][y]) {
            return;
        }
        if (res) {
            return;
        }

        if (x == destination[0] && y == destination[1]) {
            res = true;
            return;
        }

        visited[x][y] = true;

        for (int[] dir : dirs) {
            int newx = x;
            int newy = y;
            while (newx + dir[0] >= 0 && newx + dir[0] < m
                    && newy + dir[1] >= 0 && newy + dir[1] < n
                    && maze[newx + dir[0]][newy + dir[1]] == 0) {
                newx = newx + dir[0];
                newy = newy + dir[1];
            }

            dfs(maze, newx, newy, destination);
        }
    }
}
