package org.example.auz.practice.island;

/**
 * 827. making-a-large-island
 * https://leetcode.cn/problems/making-a-large-island/description/
 */
public class Num_827_1 {

    int res = 0;
    int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int[][] newGrid = new int[n][n];
                    for (int x = 0; x < n; x++) {
                        newGrid[x] = grid[x].clone();
                    }
                    newGrid[i][j] = 1;

                    res = Math.max(res, help(newGrid));
                }
            }
        }
        return res == 0 ? n * n : res;
    }

    private int help(int[][] newGrid) {
        boolean[][] visited = new boolean[n][n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && newGrid[i][j] == 1) {
                    res = Math.max(res, dfs(newGrid, i, j, visited));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] newGrid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }

        if (visited[i][j] || newGrid[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + dfs(newGrid, i + 1, j, visited)
                + dfs(newGrid, i - 1, j, visited)
                + dfs(newGrid, i, j + 1, visited)
                + dfs(newGrid, i, j - 1, visited);
    }


}
