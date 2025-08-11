package org.example.auz.practice.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class Num_59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;

        while (num <= n * n) {
            //top, left->right
            if (top <= bottom) {
                for (int j = left; j <= right; j++) {
                    matrix[top][j] = num++;
                }
                top++;
            }

            //right, top->bottom
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }

            //bottom, right->left
            if (top <= bottom) {
                for (int j = right; j >= left ; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }

            //left, bottom->top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }
}
