package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 */
public class Num_417_1 {

    int m, n;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        Deque<int[]> leftq = new ArrayDeque<>();
        boolean[][] leftVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            leftq.addLast(new int[]{i, 0});
            leftVisited[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            leftq.addLast(new int[]{0, j});
            leftVisited[0][j] = true;
        }

        bfs(heights, leftq, leftVisited);

        Deque<int[]> rightq = new ArrayDeque<>();
        boolean[][] rightVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            rightq.addLast(new int[]{i, n - 1});
            rightVisited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            rightq.addLast(new int[]{m - 1, j});
            rightVisited[m - 1][j] = true;
        }
        bfs(heights, rightq, rightVisited);

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

    private void bfs(int[][] heights, Deque<int[]> q, boolean[][] visited) {
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int cx = cur[0];
            int cy = cur[1];
            int height = heights[cx][cy];

            for (int[] dir : dirs) {
                int x = cx + dir[0];
                int y = cy + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (visited[x][y]) {
                        continue;
                    }
                    if (height > heights[x][y]) {
                        continue;
                    }

                    q.addLast(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}
