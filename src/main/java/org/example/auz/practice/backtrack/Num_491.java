package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

/**
 * 491. non-decreasing-subsequences
 * https://leetcode.cn/problems/non-decreasing-subsequences/description/?show=1
 */
public class Num_491 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        if (stack.size() > 1) {
            res.add(new ArrayList<>(stack));
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] < stack.peekLast()) {
                continue;
            }

            if (used.contains(nums[i])) {
                continue;
            }

            used.add(nums[i]);
            stack.addLast(nums[i]);
            dfs(nums, i + 1);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
        Num_491 test = new Num_491();

//        int[] arr = {4, 4, 3, 2, 1};
        int[] arr = {4, 6, 7, 7};
        test.findSubsequences(arr);
    }


}
