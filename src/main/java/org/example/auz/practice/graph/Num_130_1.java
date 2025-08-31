package org.example.auz.practice.graph;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class Num_130_1 {

    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
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

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'E';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
