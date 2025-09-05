package org.example.auz.practice.graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1631. Path With Minimum Effort
 * https://leetcode.com/problems/path-with-minimum-effort/description/
 */
public class Num_1631 {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        int[][] path = new int[m][n];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for (int[] p : path) {
            Arrays.fill(p, -1);
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int x = curNode[0];
            int y = curNode[1];
            int distFromRoot = curNode[2];

            if (distFromRoot > dist[x][y]) {
                continue;
            }

            if (x == m - 1 && y == n - 1) {
                return distFromRoot;
            }

            for (int[] nei : dirs) {
                int newx = x + nei[0];
                int newy = y + nei[1];
                if (newx >= 0 && newx < m && newy >= 0 && newy < n) {
                    int neiDist = Math.max(distFromRoot, Math.abs(heights[newx][newy] - heights[x][y]));

                    if (neiDist > dist[newx][newy]) {
                        dist[newx][newy] = neiDist;
                        path[newx][newy] = x * m + y;
                        pq.add(new int[]{newx, newy, neiDist});
                    }
                }
            }
        }

        return -1;
    }
}
