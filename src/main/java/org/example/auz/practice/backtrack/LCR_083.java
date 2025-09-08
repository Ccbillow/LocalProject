package org.example.auz.practice.backtrack;

import org.example.interview.producer.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LCR 083. 全排列
 * https://leetcode.cn/problems/VvJkup/description/?show=1
 */
public class LCR_083 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];

        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            stack.add(nums[i]);
            visited[i] = true;
            dfs(nums);
            visited[i] = false;
            stack.removeLast();
        }
    }
}
