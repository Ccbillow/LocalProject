package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1306. Jump Game III
 *
 * https://leetcode.com/problems/jump-game-iii/description/
 */
public class Num_1306_3 {

    boolean res = false;
    boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        dfs(arr, start);
        return res;
    }

    private void dfs(int[] arr, int start) {
        if (start >= arr.length || start < 0) {
            return;
        }
        if (visited[start]) {
            return;
        }

        if (res) {
            return;
        }

        if (arr[start] == 0) {
            res = true;
            return;
        }

        visited[start] = true;

        dfs(arr, start + arr[start]);
        dfs(arr, start - arr[start]);
    }
}
