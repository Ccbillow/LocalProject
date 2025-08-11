package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. Shift 2D Grid
 * https://leetcode.com/problems/shift-2d-grid/description/?show=1
 *
 * time: O(m * n)
 * space: O(m * n)
 */
public class Num_1260 {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        // O(m * n)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = grid[i][j];
            }
        }

        k = k % (m * n);
        if (k > 0) {
            // O(m * n)
            reverse(arr, 0, arr.length - 1);
            // O(k)
            reverse(arr, 0, k - 1);
            // O(m * n - k)
            reverse(arr, k, arr.length - 1);
        }

        // O(m * n)
        for (int i = 0; i < m; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                tmp.add(arr[i * n + j]);
            }
            res.add(tmp);
        }

        return res;
    }

    private static void reverse(int[] arr, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        shiftGrid(arr, 1);

//        int[][] arr = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
//        shiftGrid(arr, 4);

//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        shiftGrid(arr, 9);

        int[][] arr = {{1}, {2}, {3}, {4}, {5}, {6}, {7}};
        shiftGrid(arr, 7);
    }
}
