package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 934. shortest-bridge
 * <p>
 * https://leetcode.cn/problems/shortest-bridge/description/
 */
public class Num_934_2 {
    int m;
    int n;

    boolean[][] visited;
    Deque<int[]> q;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        q = new ArrayDeque<>();
        visited = new boolean[m][n];

        boolean flag = true;
        for (int i = 0; i < m && flag; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    flag = false;
                    break;
                }
            }
        }

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curNode = q.removeFirst();
                int x = curNode[0];
                int y = curNode[1];

                for (int[] dir : dirs) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];

                    if (newx >= 0 && newx < m
                            && newy >= 0 && newy < n
                            && !visited[newx][newy]) {
                        if (grid[newx][newy] == 1) {
                            return res;
                        }

                        visited[newx][newy] = true;
                        q.addLast(new int[]{newx, newy});
                    }

                }
            }
            res++;
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        q.addLast(new int[]{i, j});

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        Num_934_2 test = new Num_934_2();
        int[][] arr = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        test.shortestBridge(arr);
    }
}
