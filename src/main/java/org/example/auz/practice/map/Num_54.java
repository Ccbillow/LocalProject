package org.example.auz.practice.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class Num_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top_bound = 0;
        int bottom_bound = m - 1;
        int left_bound = 0;
        int right_bound = n - 1;
        List<Integer> res = new ArrayList<>();

        while (res.size() < m * n) {
            // top, left->right
            if (top_bound <= bottom_bound) {
                for (int j = left_bound; j <= right_bound; j++) {
                    res.add(matrix[top_bound][j]);
                }
                top_bound++;
            }
            // right, top->bottom
            if (left_bound <= right_bound) {
                for (int i = top_bound; i <= bottom_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                right_bound--;
            }
            // bottom, right->left
            if (top_bound <= bottom_bound) {
                for (int j = right_bound; j >= left_bound; j--) {
                    res.add(matrix[bottom_bound][j]);
                }
                bottom_bound--;
            }
            // left, bottom->top
            if (left_bound <= right_bound) {
                for (int i = bottom_bound; i >= top_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return res;
    }
}
