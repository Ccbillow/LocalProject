package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 365. water-and-jug-problem
 * https://leetcode.cn/problems/water-and-jug-problem/description/?show=1
 */
public class Num_365_1 {

    public boolean canMeasureWater(int x, int y, int target) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int a = cur[0];
            int b = cur[1];

            if (a == target || b == target || a + b == target) {
                return true;
            }

            int[][] dirs = {{x, b}, {a, y}, {0, b}, {a, 0},
                    {a - Math.min(a, y - b), b + Math.min(a, y - b)},
                    {a + Math.min(b, x - a), b - Math.min(b, x - a)}};

            for (int[] dir : dirs) {
                String key = dir[0] + "," + dir[1];
                if (!visited.contains(key)) {
                    visited.add(key);
                    q.addLast(dir);
                }
            }
        }
        return false;
    }
}
