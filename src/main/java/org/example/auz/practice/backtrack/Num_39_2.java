package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 */
public class Num_39_2 {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.addLast(candidates[i]);

                backtrack(candidates, target - candidates[i], i);

                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Num_39_2 test = new Num_39_2();

        int[] arr = {2, 3, 6, 7};
        test.combinationSum(arr, 7);
    }


}
