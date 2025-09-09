package org.example.auz.practice.island;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 694. Number of Distinct Islands
 *
 */
public class Num_694 {

    int m , n;

    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, i, j, i, j, shape);
                    set.add(String.join(";", shape));
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int x, int y, int basex, int basey, List<String> shape) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] == 0 || grid[x][y] == 2) {
            return;
        }

        grid[x][y] = 2;

        shape.add((x - basex) + "," + (y - basey));

        for (int[] dir : dirs) {
            int newx = x + dir[0];
            int newy = y + dir[1];
            dfs(grid, newx, newy, basex, basey, shape);
        }
    }

}
