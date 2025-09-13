package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 365. water-and-jug-problem
 * https://leetcode.cn/problems/water-and-jug-problem/description/?show=1
 */
public class Num_365_5 {

    public boolean canMeasureWater(int x, int y, int target) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        int[] dirs = {x, -x, y, -y};

        while (!q.isEmpty()) {
            int cur = q.removeFirst();

            if (cur == target) {
                return true;
            }

            for (int d : dirs) {
                int val = cur + d;

                if (val > x + y || val < 0) {
                    continue;
                }

                if (visited.contains(val)) {
                    continue;
                }

                q.addLast(val);
                visited.add(val);
            }
        }

        return false;
    }


}
