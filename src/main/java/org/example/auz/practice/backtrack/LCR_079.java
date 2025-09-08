package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LCR 079. 子集
 * https://leetcode.cn/problems/TVdhkn/description/?show=1
 */
public class LCR_079 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int idx) {
        res.add(new ArrayList<>(stack));

        for (int i = idx; i < nums.length; i++) {
            stack.add(nums[i]);
            dfs(nums, i + 1);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
        LCR_079 test = new LCR_079();
        int[] arr = {1, 2, 3};
        test.subsets(arr);
    }
}
