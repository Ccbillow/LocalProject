package org.example.auz.practice.graph.bellman;

import java.util.Arrays;

/**
 * 743. network-delay-time
 *
 * https://leetcode.cn/problems/network-delay-time/description/
 *
 * time: O (V * E)
 */
public class Num_743_2 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean update = false;

            for (int[] edge : times) {
                if (dist[edge[0]] != Integer.MAX_VALUE && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                    update = true;
                }
            }

            if (!update) {
                break;
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, dist[i]);
        }
        return res;
    }

}
