package org.example.auz.practice.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 45. jump-game-ii
 * https://leetcode.cn/problems/jump-game-ii/description/
 */
public class Num_45_1 {

    public int jump(int[] nums) {
        int n = nums.length;

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;

        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int idx = q.removeFirst();

                if (idx >= n - 1) {
                    return step;
                }

                for (int j = idx + 1; j <= idx + nums[idx]; j++) {
                    if (j >= n) {
                        continue;
                    }

                    if (!visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
