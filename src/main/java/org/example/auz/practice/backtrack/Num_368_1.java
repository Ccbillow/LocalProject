package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 368. largest-divisible-subset
 * https://leetcode.cn/problems/largest-divisible-subset/description/?show=1
 */
public class Num_368_1 {

    int max = Integer.MIN_VALUE;

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> stack = new ArrayDeque<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return List.of(nums[0]);
        }

        Arrays.sort(nums);

        dfs(nums, 0);

        for (List<Integer> re : res) {
            if (max == re.size()) {
                return re;
            }
        }
        return new ArrayList<>();
    }

    private void dfs(int[] nums, int start) {
        if (!stack.isEmpty()) {
            res.add(new ArrayList<>(stack));
            max = Math.max(max, stack.size());
        }

        for (int i = start; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] % stack.peekLast() != 0) {
                continue;
            }

            stack.addLast(nums[i]);

            dfs(nums, i + 1);

            stack.removeLast();

        }
    }
}
