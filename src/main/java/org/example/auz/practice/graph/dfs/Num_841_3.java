package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 841. Keys and Rooms
 *
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class Num_841_3 {


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                int cur = stack.removeLast();

                for (Integer nei : rooms.get(cur)) {
                    if (!visited[nei]) {
                        stack.addLast(nei);
                        visited[nei] = true;
                    }
                }
            }
        }

        boolean res = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res = false;
            }
        }
        return res;
    }


}
