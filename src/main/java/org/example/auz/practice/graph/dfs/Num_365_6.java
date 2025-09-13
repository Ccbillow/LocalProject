package org.example.auz.practice.graph.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 365. water-and-jug-problem
 * https://leetcode.cn/problems/water-and-jug-problem/description/?show=1
 */
public class Num_365_6 {

    boolean res = false;

    public boolean canMeasureWater(int x, int y, int target) {
        Set<Integer> visited = new HashSet<>();

        int[] dirs = {x, -x, y, -y};

        dfs(dirs, 0, target, visited, x + y);
        return res;
    }

    private void dfs(int[] dirs, int cur, int target, Set<Integer> visited, int max) {
        if (cur < 0 || cur > max) {
            return;
        }

        if (visited.contains(cur)) {
            return;
        }

        if (res) {
            return;
        }

        if (cur == target) {
            res = true;
            return;
        }

        visited.add(cur);

        for (int dir : dirs) {
            dfs(dirs, cur + dir, target, visited, max);
        }
    }
}
