package org.example.auz.practice.graph;

/**
 * 529. Minesweeper
 *
 * https://leetcode.com/problems/minesweeper/description/
 */
public class Num_529_1 {

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    private int m,n;

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'E') {
            return;
        }

        int mines = countMines(board, x, y);
        if (mines > 0) {
            board[x][y] = (char) (mines + '0');
        } else {
            board[x][y] = 'B';
            for (int[] dir : dirs) {
                dfs(board, x + dir[0], y + dir[1]);
            }
        }
    }

    int countMines(char[][] board, int x, int y) {
        int count = 0;

        for (int[] dir : dirs) {
            int X = x + dir[0];
            int Y = y + dir[1];
            if (X >= 0 && X < m && Y >= 0 && Y < n && board[X][Y] == 'M') {
                count++;
            }
        }
        return count;
    }
}
