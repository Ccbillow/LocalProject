package org.example.auz.practice.graph.uf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 934. shortest-bridge
 * <p>
 * https://leetcode.cn/problems/shortest-bridge/description/
 *
 * uf
 */
public class Num_934_1 {

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        UF uf = new UF(n * n);

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int x = i * n + j;
                    for (int[] dir : dirs) {
                        int newx = i + dir[0];
                        int newy = j + dir[1];
                        if (newx >= 0 && newx < n
                                && newy >= 0 && newy < n
                                && grid[newx][newy] == 1) {
                            int y = newx * n + newy;
                            uf.union(x, y);
                        }
                    }
                }
            }
        }

        Map<Integer, List<int[]>> islands = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int root = uf.find(i * n + j);
                    islands.computeIfAbsent(root,
                            k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        ArrayList<List<int[]>> lists = new ArrayList<>(islands.values());
        List<int[]> island1 = lists.get(0);
        List<int[]> island2 = lists.get(1);

        int res = Integer.MAX_VALUE;
        for (int[] p1 : island1) {
            for (int[] p2 : island2) {
                int d = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]) - 1;
                res = Math.min(res, d);
            }
        }
        return res;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                parent[rootx] = rooty;
                count--;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
