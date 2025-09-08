package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. n-queens
 * https://leetcode.cn/problems/n-queens/description/
 */
public class Num_51_2 {

    List<List<String>> res = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (char[] c : chess) {
            Arrays.fill(c, '.');
        }

        backtrack(chess,0);
        return res;
    }

    private void backtrack(char[][] chess, int cur) {
        int n = chess.length;

        if (cur == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : chess) {
                list.add(new String(c));
            }
            res.add(list);
        }

        for (int j = 0; j < n; j++) {
            if (valid(cur, j, chess)) {
                chess[cur][j] = 'Q';

                backtrack(chess, cur + 1);

                chess[cur][j] = '.';
            }
        }
    }

    private boolean valid(int row, int col, char[][] chess) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        for (int j = 0; j < col; j++) {
            if (chess[row][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= chess.length - 1; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


}
