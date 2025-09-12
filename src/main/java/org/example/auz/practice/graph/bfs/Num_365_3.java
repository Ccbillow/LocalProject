package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 365. water-and-jug-problem
 * https://leetcode.cn/problems/water-and-jug-problem/description/?show=1
 */
public class Num_365_3 {

    public boolean canMeasureWater(int x, int y, int target) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            if (cur == target) {
                return true;
            }

            if (cur <= y) {
                int val = cur + x;
                if (!visited.contains(val)) {
                    q.addLast(val);
                    visited.add(val);
                }
            }

            if (cur <= x) {
                int val = cur + y;
                if (!visited.contains(val)) {
                    q.addLast(val);
                    visited.add(val);
                }
            }

            if (cur >= x) {
                int val = cur - x;
                if (!visited.contains(val)) {
                    q.addLast(val);
                    visited.add(val);
                }
            }

            if (cur >= y) {
                int val = cur - y;
                if (!visited.contains(val)) {
                    q.addLast(val);
                    visited.add(val);
                }
            }
        }
        return false;
    }


}
