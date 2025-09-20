package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 377. combination-sum-iv
 * https://leetcode.cn/problems/combination-sum-iv/description/
 */
public class Num_377_1 {

    int res = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    int sum = 0;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        dfs(nums, target);
        return res;
    }

    private void dfs(int[] nums, int target) {
        if (sum == target) {
            res++;
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            stack.add(nums[i]);
            dfs(nums, target);
            stack.removeLast();
            sum = sum - nums[i];
        }
    }

    public static void main(String[] args) {
        Num_377_1 test = new Num_377_1();

        int[] arr = {1, 2, 3};
        test.combinationSum4(arr, 4);
    }
}
