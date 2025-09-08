package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 40. combination-sum-ii
 *
 * https://leetcode.cn/problems/combination-sum-ii/description/
 */
public class Num_40_2 {


    Set<List<Integer>> res = new HashSet<>();

    List<Integer> track = new ArrayList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrack(candidates, 0, target, sum);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] candidates, int cur, int target, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            if (sum < target) {
                sum = sum + candidates[i];
                track.add(candidates[i]);

                backtrack(candidates, i + 1, target, sum);

                track.remove(track.size() - 1);
                sum = sum - candidates[i];
            }
        }
    }

}
