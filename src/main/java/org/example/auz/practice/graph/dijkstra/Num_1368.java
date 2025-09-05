package org.example.auz.practice.graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1368. minimum-cost-to-make-at-least-one-valid-path-in-a-grid
 * https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
 */
public class Num_1368 {

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int x = curNode[0];
            int y = curNode[1];
            int distFromRoot = curNode[2];

            if (x == m - 1 && y == n - 1) {
                return distFromRoot;
            }

            for (int[] dir : dirs) {
                int newx = x + dir[0];
                int newy = y + dir[1];

                int newDist;
                if (newx >= 0 && newx < m
                        && newy >= 0 && newy < n) {
                    int curDir = grid[x][y];

                    if (curDir == 1 && dir[0] == 0 && dir[1] == 1) {
                        newDist = distFromRoot;
                    } else if (curDir == 2 && dir[0] == 0 && dir[1] == -1) {
                        newDist = distFromRoot;
                    } else if (curDir == 3 && dir[0] == 1 && dir[1] == 0) {
                        newDist = distFromRoot;
                    } else if (curDir == 4 && dir[0] == -1 && dir[1] == 0) {
                        newDist = distFromRoot;
                    } else {
                        newDist = distFromRoot + 1;
                    }

                    if (newDist < dist[newx][newy]) {
                        pq.add(new int[]{newx, newy, newDist});
                        dist[newx][newy] = newDist;
                    }
                }
            }
        }
        return 0;
    }
}
