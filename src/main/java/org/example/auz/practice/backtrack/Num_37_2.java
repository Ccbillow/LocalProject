package org.example.auz.practice.backtrack;

/**
 * 37. sudoku-solver
 * https://leetcode.cn/problems/sudoku-solver/description/
 */
public class Num_37_2 {


    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (valid(board, i, j, k)) {
                            board[i][j] = k;
                        }

                        boolean result = solve(board);
                        if (result) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == ch && i != k) {
                return false;
            }
        }
        for (int k = 0; k < board[0].length; k++) {
            if (board[i][k] == ch && j != k) {
                return false;
            }
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
