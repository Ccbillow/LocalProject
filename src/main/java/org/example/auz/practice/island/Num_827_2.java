package org.example.auz.practice.island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 827. making-a-large-island
 * https://leetcode.cn/problems/making-a-large-island/description/
 */
public class Num_827_2 {

    int m;
    int n;

    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 2;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Integer curArea = dfs(grid, i, j, idx);
                    map.put(idx, curArea);
                    idx++;
                    res = Math.max(res, curArea);
                }
            }
        }

        if (res == 0) {
            return 1;
        }


        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int curArea = 1;
                    Set<Integer> idSet = new HashSet<>();
                    for (int[] dir : dirs) {
                        int newi = i + dir[0];
                        int newj = j + dir[1];
                        if (newi >= 0 && newi < m && newj >= 0 && newj < n && grid[newi][newj] != 0) {
                            idSet.add(grid[newi][newj]);
                        }
                    }
                    if (idSet.isEmpty()) {
                        continue;
                    }


                    for (Integer id : idSet) {
                        curArea = curArea + map.get(id);
                    }

                    res = Math.max(res, curArea);
                }
            }
        }

        return res;
    }

    private Integer dfs(int[][] grid, int i, int j, int idx) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = idx;

        return 1 + dfs(grid, i + 1, j, idx)
                + dfs(grid, i - 1, j, idx)
                + dfs(grid, i, j + 1, idx)
                + dfs(grid, i, j - 1, idx);
    }

    public static void main(String[] args) {
        Num_827_2 test = new Num_827_2();
        int[][] arr = {{1, 0}, {0, 1}};
        test.largestIsland(arr);
    }

}
