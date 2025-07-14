package org.example.auz.blind75.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 *
 * time: O(2^n) ~ O(n!)
 * space: O(target) 递归栈
 */
public class Num_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
