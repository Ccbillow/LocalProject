package org.example.auz.practice.backtrack;

import org.example.auz.practice.graph.DfsTemp;

/**
 * 547. number-of-provinces
 * https://leetcode.cn/problems/number-of-provinces/description/?show=1
 */
public class Num_547_3 {

    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];

        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, int idx) {
        visited[idx] = true;

        for (int j = 0; j < isConnected[0].length; j++) {
            if (visited[j]) {
                continue;
            }

            if (isConnected[idx][j] == 1) {
                dfs(isConnected, j);
            }
        }
    }
}
