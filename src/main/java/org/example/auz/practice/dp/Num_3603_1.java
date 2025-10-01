package org.example.auz.practice.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 3603. minimum-cost-path-with-alternating-directions-ii
 * https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-ii/description/
 */
public class Num_3603_1 {

    public long minCost(int m, int n, int[][] waitCost) {
        PriorityQueue<Object[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> (Long) a[2]));
        q.add(new Object[]{0, 0, 1L});

        long[][] cost = new long[m][n];
        for (long[] c : cost) {
            Arrays.fill(c, Long.MAX_VALUE);
        }

        int[][] dirs = {{1, 0}, {0, 1}};

        while (!q.isEmpty()) {
            Object[] cur = q.poll();
            int x = (int) cur[0];
            int y = (int) cur[1];
            long curCost = (long) cur[2];

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < m && ny < n) {
                    long newCost = curCost + (long) (nx + 1) * (ny + 1) + waitCost[nx][ny];
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        q.add(new Object[]{nx, ny, newCost});
                    }
                }
            }
        }
        return cost[m - 1][n - 1] - waitCost[m - 1][n - 1];
    }
}
