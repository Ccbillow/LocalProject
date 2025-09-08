package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Factor Combinations
 */
public class Num_254 {

    List<List<Integer>> res = new ArrayList<>();

    Deque<Integer> stack = new ArrayDeque<>();

    int sum = 1;

    public List<List<Integer>> getFactors(int n) {
        int[] arr = new int[n - 2];
        for (int i = 0; i < n - 2; i++) {
            arr[i] = i + 2;
        }

        dfs(arr, 0, n);
        return res;
    }

    private void dfs(int[] arr, int start, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(stack));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < arr.length; i++) {
            sum = sum * arr[i];
            stack.addLast(arr[i]);


            dfs(arr, i, target);

            sum = sum / arr[i];
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
        Num_254 test = new Num_254();
//        test.getFactors(12);
        test.getFactors(32);
    }
}
