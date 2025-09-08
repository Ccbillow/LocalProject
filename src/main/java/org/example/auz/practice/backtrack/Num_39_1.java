package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 */
public class Num_39_1 {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            sum = sum + candidates[i];

            backtrack(candidates, target, i, sum);

            path.removeLast();
            sum = sum - candidates[i];
        }
    }

    public static void main(String[] args) {
        Num_39_1 test = new Num_39_1();

        int[] arr = {2, 3, 6, 7};
        test.combinationSum(arr, 7);
    }


}
