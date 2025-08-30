package org.example.auz.practice.graph;

/**
 * 947. Most Stones Removed with Same Row or Column
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/?show=1
 */
public class Num_947_2 {

    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        int res = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                dfs(stones, i, visited);
                res++;
            }
        }
        return stones.length - res;
    }

    void dfs(int[][] stones, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < stones.length; j++) {
            if (visited[j]) {
                continue;
            }

            if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                dfs(stones, j, visited);
            }
        }
    }

}
