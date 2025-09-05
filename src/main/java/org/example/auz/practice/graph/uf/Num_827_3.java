package org.example.auz.practice.graph.uf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 827. making-a-large-island
 * https://leetcode.cn/problems/making-a-large-island/description/
 *
 * uf
 */
public class Num_827_3 {

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        UF uf = new UF(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni >= 0 && ni < m
                            && nj >= 0 && nj < n
                            && grid[ni][nj] == 1) {
                        uf.union(id, ni * n + nj);
                    }
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int root = uf.find(i * n + j);
                    map.put(root, map.getOrDefault(root, 0) + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int sum = 1;
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < m
                                && nj >= 0 && nj < n
                                && grid[ni][nj] == 1) {
                            int root = uf.find(ni * n + nj);
                            if (set.add(root)) {
                                sum = sum + map.get(root);
                            }
                        }
                    }
                    res = Math.max(res, sum);
                }
            }
        }

        for (Integer area : map.values()) {
            res = Math.max(res, area);
        }

        return res;
    }

    class UF {
        int count;
        int[] parent;
        int[] rank;

        public UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
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
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rootx] = rooty;
                    rank[rooty]++;
                }
            }
        }
    }
}
