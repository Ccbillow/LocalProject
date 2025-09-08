package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. n-queens
 * https://leetcode.cn/problems/n-queens/description/
 */
public class Num_51_1 {

    List<List<String>> res = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        List<String> track = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            track.add(".".repeat(n));
        }

        backtrack(track, 0);

        return res;
    }

    private void backtrack(List<String> track, int row) {
        if (row == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }

        int n = track.get(row).length();
        for (int i = 0; i < n; i++) {
            if (valid(track, row, i)) {
                char[] newRow = track.get(row).toCharArray();
                newRow[i] = 'Q';
                track.set(row, new String(newRow));
                backtrack(track, row + 1);
                newRow[i] = '.';
                track.set(row, new String(newRow));
            }
        }
    }

    private boolean valid(List<String> track, int row, int col) {
        int n = track.size();
        for (int i = 0; i < row; i++) {
            if (track.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (track.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (track.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
