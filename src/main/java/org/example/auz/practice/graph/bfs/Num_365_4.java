package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 365. water-and-jug-problem
 * https://leetcode.cn/problems/water-and-jug-problem/description/?show=1
 */
public class Num_365_4 {

    public boolean canMeasureWater(int x, int y, int target) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        int[] dirs = {x, y, -x, -y};

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            if (cur == target) {
                return true;
            }

            for (int dir : dirs) {
                int val = cur + dir;

                if (!visited.contains(val)) {
                    if (val < 0 || val > x + y) {
                        continue;
                    }

                    visited.add(val);
                    q.addLast(val);
                }
            }
        }
        return false;
    }


}
