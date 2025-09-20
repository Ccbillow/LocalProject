package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 2850. minimum-moves-to-spread-stones-over-grid
 *
 * https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/description/
 */
public class Num_2850_1 {
    int res = Integer.MAX_VALUE;

    boolean[] visited;

    public int minimumMoves(int[][] grid) {
        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {
                    int more = grid[i][j];
                    while (more > 1) {
                        from.add(new int[]{i, j});
                        more--;
                    }
                } else if (grid[i][j] == 0) {
                    to.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[to.size()];

        dfs(from, to, 0, 0);
        
        return res;
    }

    private void dfs(List<int[]> from, List<int[]> to, int idx, int cost) {
        if (idx == from.size()) {
            res = Math.min(res, cost);
            return;
        }

        int[] f = from.get(idx);
        for (int i = 0; i < to.size(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            int[] t = to.get(i);
            int dist = Math.abs(f[0] - t[0]) + Math.abs(f[1] - t[1]);
            dfs(from, to, idx + 1, cost + dist);
            visited[i] = false;
        }
    }
}
