package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Num_39 {

    List<List<Integer>> res = new ArrayList<>();

    List<Integer> track = new ArrayList<>();

    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int cur, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            sum = sum + candidates[i];
            track.add(candidates[i]);

            backtrack(candidates, i, target);

            sum = sum - candidates[i];
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Num_39 test = new Num_39();

        int[] arr = {2, 3, 6, 7};
        test.combinationSum(arr, 7);
    }
}
