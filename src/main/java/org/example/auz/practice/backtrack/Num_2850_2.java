package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 2850. Minimum Moves to Spread Stones Over Grid
 * https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/description/?show=1
 */
public class Num_2850_2 {

    int res = Integer.MAX_VALUE;
    
    public int minimumMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        List<int[]> from = new ArrayList<>();
        List<int[]> to = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    to.add(new int[]{i, j});
                }
                if (grid[i][j] > 1) {
                    from.add(new int[]{i, j, grid[i][j]});
                }
            }
        }


        dfs(from, to, 0);

        return res;
    }

    private void dfs(List<int[]> from, List<int[]> to, int steps) {
        if (to.size() == 0) {
            res = Math.min(res, steps);
        }

        for (int i = 0; i < to.size(); i++) {
            for (int j = 0; j < from.size(); j++) {
                if (from.get(j)[2] > 1) {
                    from.get(j)[2]--;
                } else {
                    continue;
                }

                int fromx = from.get(j)[0];
                int fromy = from.get(j)[1];
                int tox = to.get(i)[0];
                int toy = to.get(i)[1];
                int curSteps = Math.abs(tox - fromx) + Math.abs(toy - fromy);

                int[] tmp = to.get(i);
                to.remove(i);
                dfs(from, to, curSteps + steps);
                to.add(i, tmp);
                if (from.get(j)[2] >= 1) {
                    from.get(j)[2]++;
                }
            }
        }
    }
}
