package org.example.auz.practice.graph;

import java.util.LinkedList;

/**
 * 947. Most Stones Removed with Same Row or Column
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/?show=1
 */
public class Num_947_3 {

    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        int res = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                bfs(stones, i, visited);
                res++;
            }
        }
        return stones.length - res;
    }

    void bfs(int[][] stones, int i, boolean[] visited) {
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            for (int j = 0; j < stones.length; j++) {
                if (visited[j]) {
                    continue;
                }

                if (stones[cur][0] == stones[j][0] || stones[cur][1] == stones[j][1]) {
                    q.addLast(j);
                    visited[j] = true;
                }
            }
        }
    }

}
