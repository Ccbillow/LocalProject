package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * LCR 084. 全排列 II
 * https://leetcode.cn/problems/7p8L0Z/description/
 */
public class LCR_084 {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> stack = new ArrayDeque<>();

    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        visited = new boolean[nums.length];
        dfs(nums, visited);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            stack.addLast(nums[i]);

            dfs(nums, visited);

            stack.removeLast();
            visited[i] = false;
        }
    }

}
