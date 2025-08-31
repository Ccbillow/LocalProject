package org.example.auz.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 200. Number of Islands
 * <p>
 * https://leetcode.com/problems/number-of-islands/description/?show=1
 *
 * uf
 */
public class Num_200_3 {

    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int water = 0;
        UF uf = new UF(m * n);
        int[][] dirs = {{1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    water++;
                } else {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < m && y < n && grid[x][y] == '1') {
                            uf.union(getIndex(i, j), getIndex(x, y));
                        }
                    }
                }
            }
        }
        return uf.count() - water;
    }

    int getIndex(int i, int j) {
        return i * n + j;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int count() {
            return count;
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                return parent[x] = find(parent[x]);
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                count--;
                parent[rootX] = rootY;
            }
        }

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

}
