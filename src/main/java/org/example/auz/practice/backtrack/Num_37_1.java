package org.example.auz.practice.backtrack;

/**
 * 37. sudoku-solver
 * https://leetcode.cn/problems/sudoku-solver/description/
 */
public class Num_37_1 {

    boolean found = false;

    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    private void backtrack(char[][] board, int index) {
        if (found) {
            return;
        }

        int m = 9, n = 9;
        int i = index / n, j = index % n;
        if (index == m * n) {
            found = true;
            return;
        }

        if (board[i][j] != '.') {
            backtrack(board, index + 1);
            return;
        }


        for (char ch = '1'; ch <= '9'; ch++) {
            if (!valid(board, i, j, ch)) {
                continue;
            }

            board[i][j] = ch;

            backtrack(board, index + 1);

            if (found) {
                return;
            }

            board[i][j] = '.';
        }
    }

    private boolean valid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == ch) {
                return false;
            }
            if (board[k][j] == ch) {
                return false;
            }
//            if (board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == ch) {
//                return false;
//            }
        }

        int x = (i / 3) * 3;
        int y = (j / 3) * 3;
        for (int k1 = x; k1 < x + 3; k1++) {
            for (int k2 = y; k2 < y + 3; k2++) {
                if (board[k1][k2] == ch && (k1 != i || k2 != j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
