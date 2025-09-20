package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 */
public class Num_322_2 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(amount);
        boolean[] visited = new boolean[amount + 1];
        visited[amount] = true;

        int step = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();

                for (int nei : coins) {
                    int val = cur - nei;

                    if (val == 0) {
                        return step;
                    }
                    if (val < 0) {
                        continue;
                    }

                    if (!visited[val]) {
                        visited[val] = true;
                        q.add(val);
                    }
                }
            }

            step++;
        }

        return -1;
    }
}
