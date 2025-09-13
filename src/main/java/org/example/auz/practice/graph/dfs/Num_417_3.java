package org.example.auz.practice.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 */
public class Num_417_3 {

    int m, n;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] leftVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, heights[i][0], leftVisited);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, heights[0][j], leftVisited);
        }

        boolean[][] rightVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, heights[i][n - 1], rightVisited);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, heights[m - 1][j], rightVisited);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (leftVisited[i][j] && rightVisited[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int x, int y, int preHeight, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        if (heights[x][y] < preHeight) {
            return;
        }

        visited[x][y] = true;

        for (int[] dir : dirs) {
            dfs(heights, x + dir[0], y + dir[1], heights[x][y], visited);
        }
    }
}
