package org.example.auz.practice.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2035. partition-array-into-two-arrays-to-minimize-sum-difference
 * https://leetcode.cn/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/
 */
public class Num_2035_1 {

    int res = Integer.MAX_VALUE;

    Deque<Integer> path = new ArrayDeque<>();

    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        dfs(nums, sum, 0);
        return res;
    }

    private void dfs(int[] nums, int sum, int idx) {
        if (path.size() > nums.length / 2) {
            return;
        }

        if (idx == nums.length) {
            if (path.size() == nums.length / 2) {
                int cur = 0;
                for (Integer i : path) {
                    cur += i;
                }
                res = Math.min(res, Math.abs(cur - (sum - cur)));
            }
            return;
        }

        //choose nums[idx]
        path.addLast(nums[idx]);
        dfs(nums, sum, idx + 1);
        path.removeLast();

        //not chooes nums[idx]
        dfs(nums, sum, idx + 1);
    }
}
