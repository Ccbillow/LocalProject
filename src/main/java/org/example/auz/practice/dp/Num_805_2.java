package org.example.auz.practice.dp;

import java.util.Arrays;

/**
 * 805. split-array-with-same-average
 * https://leetcode.cn/problems/split-array-with-same-average/description/
 */
public class Num_805_2 {

    int n;
    boolean res = false;
    int totalSum = 0;

    public boolean splitArraySameAverage(int[] nums) {
        n = nums.length;

        for (int v : nums) {
            totalSum += v;
        }

        Arrays.sort(nums);

        for (int i = 1; i <= n / 2; i++) {
            if ((totalSum * i) % n != 0) {
                continue;
            }

            int target = totalSum * i / n;

            dfs(nums, 0, 0, 0, i, target);

            if (res) {
                return true;
            }
        }

        return res;
    }

    private void dfs(int[] nums, int idx, int count, int sum, int k, int target) {
        if (res) {
            return;
        }

        if (count > k) {
            return;
        }

        if (count == k) {
            if (sum == target) {
                res = true;
            }
            return;
        }

        if (idx == n) {
            return;
        }

        if (n - idx < k - count) return;

        if (sum + (k - count) * nums[n - 1] < target) {
            return;
        }

        if (sum > target) {
            return;
        }

        dfs(nums, idx + 1, count + 1, sum + nums[idx], k, target);

        dfs(nums, idx + 1, count, sum, k, target);
    }


}
