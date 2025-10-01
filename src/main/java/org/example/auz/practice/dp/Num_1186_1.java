package org.example.auz.practice.dp;

/**
 * 1186. maximum-subarray-sum-with-one-deletion
 * https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/description/
 */
public class Num_1186_1 {

    public int maximumSum(int[] arr) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, Math.max(dfs(arr, i, false), dfs(arr, i, true)));
        }
        return res;
    }

    int dfs(int[] arr, int i, boolean del) {
        if (i < 0) {
            return Integer.MIN_VALUE / 2;
        }

        if (!del) {
            return Math.max(dfs(arr, i - 1, false), 0) + arr[i];
        }

        return Math.max(dfs(arr, i - 1, true) + arr[i], dfs(arr, i - 1, false));
    }
}
