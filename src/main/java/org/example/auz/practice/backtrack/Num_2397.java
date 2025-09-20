package org.example.auz.practice.backtrack;

/**
 * 2397. maximum-rows-covered-by-columns
 * https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/
 */
public class Num_2397 {

    int res = 0;
    int m, n;
    int[] nums;

    public int maximumRows(int[][] matrix, int numSelect) {
        m = matrix.length;
        n = matrix[0].length;
        nums = new int[n];

        dfs(matrix, 0, 0, numSelect);
        return res;
    }

    private void dfs(int[][] matrix, int idx, int cur, int numSelect) {
        if (cur == numSelect) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (cover(matrix[i], nums)) {
                    count++;
                }
            }
            res = Math.max(res, count);
            return;
        }

        for (int i = idx; i < n; i++) {
            nums[i] = 1;
            dfs(matrix, i + 1, cur + 1, numSelect);
            nums[i] = 0;
        }
    }

    private boolean cover(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1 && b[i] == 0) {
                return false;
            }
        }

        return true;
    }
}
