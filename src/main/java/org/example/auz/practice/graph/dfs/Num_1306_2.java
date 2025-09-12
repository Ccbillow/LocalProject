package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1306. Jump Game III
 *
 * https://leetcode.com/problems/jump-game-iii/description/
 */
public class Num_1306_2 {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int cur = stack.removeLast();

            if (arr[cur] == 0) {
                return true;
            }

            int right = cur + arr[cur];
            int left = cur - arr[cur];
            if (right < arr.length && !visited[right]) {
                visited[right] = true;
                stack.addLast(right);
            }
            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                stack.addLast(left);
            }
        }
        return false;
    }
}
