package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 996.number-of-squareful-arrays
 * https://leetcode.cn/problems/number-of-squareful-arrays/description/?show=1
 */
public class Num_996 {

    Deque<Integer> stack = new ArrayDeque<>();

    int res = 0;

    boolean[] visited;

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);

        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (nums.length == stack.size()) {
            res++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (!stack.isEmpty() && !check(nums[i], stack.peekLast())) {
                continue;
            }

            stack.addLast(nums[i]);
            visited[i] = true;
            dfs(nums);
            visited[i] = false;
            stack.removeLast();
        }
    }

    private boolean check(int a, int b) {
        int sqrt = (int) Math.sqrt(a + b);
        return sqrt * sqrt == a + b;
    }


}
