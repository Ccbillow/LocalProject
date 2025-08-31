package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class Num_130_2 {

    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void bfs(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        board[i][j] = 'E';
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 'O') {
                    board[newX][newY] = 'E';
                    q.addLast(new int[]{newX, newY});
                }
            }
        }
    }
}
