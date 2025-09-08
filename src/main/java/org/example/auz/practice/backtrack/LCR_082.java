package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * LCR 082.
 * https://leetcode.cn/problems/4sjJUc/description/
 */
public class LCR_082 {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> stack = new ArrayDeque<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(candidates, target, 0);
        return res;
    }

    void dfs(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(stack));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            sum = sum + candidates[i];
            stack.addLast(candidates[i]);

            dfs(candidates, target, i + 1);

            sum = sum - candidates[i];
            stack.removeLast();
        }
    }
}
