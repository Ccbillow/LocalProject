package org.example.auz.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1755. closest-subsequence-sum
 * https://leetcode.cn/problems/closest-subsequence-sum/description/
 */
public class Num_1755_1 {

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);

        List<Integer> leftSum = new ArrayList<>();
        List<Integer> rightSum = new ArrayList<>();
        dfs(left, 0, 0, leftSum);
        dfs(right, 0, 0, rightSum);

        Collections.sort(rightSum);

        int res = Integer.MAX_VALUE;

        for (Integer l : leftSum) {
            int target = goal - l;

            int idx = Collections.binarySearch(rightSum, target);
            if (idx >= 0) {
                return 0;
            } else {
                idx = -idx - 1;

                if (idx < rightSum.size()) {
                    res = Math.min(res, l + rightSum.get(idx) - goal);
                }

                if (idx > 0) {
                    res = Math.min(res, l + rightSum.get(idx - 1) - goal);
                }
            }
        }

        return res;
    }

    private void dfs(int[] arr, int idx, int sum, List<Integer> leftSum) {
        if (idx == arr.length) {
            leftSum.add(sum);
            return;
        }
        // not choose arr[idx]
        dfs(arr, idx + 1, sum, leftSum);
        
        // choose arr[idx]
        dfs(arr, idx + 1, sum + arr[idx], leftSum);
    }

    public static void main(String[] args) {
        Num_1755_1 test = new Num_1755_1();
        int[] arr = {5, -7, 3, 5};
        test.minAbsDifference(arr, 6);
    }


}
