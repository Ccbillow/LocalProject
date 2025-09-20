package org.example.auz.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1755. closest-subsequence-sum
 * https://leetcode.cn/problems/closest-subsequence-sum/description/
 */
public class Num_1755 {

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);

        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();

        generate(left, 0, 0, leftSums);
        generate(right, 0, 0, rightSums);

        Collections.sort(rightSums);

        int res = Math.abs(goal);

        for (Integer l : leftSums) {
            int target = goal - l;

            int idx = Collections.binarySearch(rightSums, target);
            if (idx >= 0) {
                return 0;
            } else {
                int insert = -idx - 1;
                if (insert < rightSums.size()) {
                    int candidate = l + rightSums.get(insert);
                    res = Math.min(res, Math.abs(candidate - goal));
                }

                if (insert > 0) {
                    int candidate = l + rightSums.get(insert - 1);
                    res = Math.min(res, Math.abs(candidate - goal));
                }
            }
        }
        return res;
    }

    private void generate(int[] arr, int idx, int sum, List<Integer> result) {
        if (idx == arr.length) {
            result.add(sum);
            return;
        }

        generate(arr, idx + 1, sum + arr[idx], result);

        generate(arr, idx + 1, sum, result);
    }
}
