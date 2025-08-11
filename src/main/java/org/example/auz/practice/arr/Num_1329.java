package org.example.auz.practice.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1329. Sort the Matrix Diagonally
 * https://leetcode.com/problems/sort-the-matrix-diagonally/description/?show=1
 */
public class Num_1329 {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalId = i - j;
                map.putIfAbsent(diagonalId, new ArrayList<>());
                map.get(diagonalId).add(mat[i][j]);
            }
        }

        for (List<Integer> list : map.values()) {
//            list.sort(Comparator.reverseOrder());
            list.sort((a, b) -> b - a);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> list = map.get(i - j);
                mat[i][j] = list.remove(list.size() - 1);
            }
        }

        return mat;
    }
}
