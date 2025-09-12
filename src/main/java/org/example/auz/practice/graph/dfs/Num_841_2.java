package org.example.auz.practice.graph.dfs;

import java.util.List;

/**
 * 841. Keys and Rooms
 *
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class Num_841_2 {

    boolean[] visited;
    int count = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];

        dfs(rooms, 0);

        return count == n;
    }

    private void dfs(List<List<Integer>> rooms, int idx) {
        visited[idx] = true;
        count++;

        for (Integer nei : rooms.get(idx)) {
            if (!visited[nei]) {
                dfs(rooms, nei);
            }
        }
    }
}
