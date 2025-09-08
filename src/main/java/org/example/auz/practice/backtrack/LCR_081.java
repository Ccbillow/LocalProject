package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LCR 081. 组合总和
 * https://leetcode.cn/problems/Ygoe9J/description/?show=1
 */
public class LCR_081 {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> stack = new ArrayDeque<>();

    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(stack));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            sum = sum + candidates[i];
            stack.addLast(candidates[i]);

            dfs(candidates, target, i);

            sum = sum - candidates[i];
            stack.removeLast();
        }
    }
}
