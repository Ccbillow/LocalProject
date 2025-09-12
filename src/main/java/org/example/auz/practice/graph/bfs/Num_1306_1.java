package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1306. Jump Game III
 *
 * https://leetcode.com/problems/jump-game-iii/description/
 */
public class Num_1306_1 {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();

            if (arr[cur] == 0) {
                return true;
            }

            if (cur + arr[cur] < arr.length && !visited[cur + arr[cur]]) {
                visited[cur + arr[cur]] = true;
                q.add(cur + arr[cur]);
            }
            if (cur - arr[cur] >= 0 && !visited[cur - arr[cur]]) {
                visited[cur - arr[cur]] = true;
                q.add(cur - arr[cur]);
            }
        }
        return false;
    }
}
