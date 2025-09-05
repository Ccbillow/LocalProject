package org.example.auz.practice.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 815. bus-routes
 * https://leetcode.cn/problems/bus-routes/description/
 */
public class Num_815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> bus2Indexes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int r : routes[i]) {
                bus2Indexes.computeIfAbsent(r, k -> new ArrayList<>()).add(i);
            }
        }

        Set<Integer> visitedRoute = new HashSet<>();
        Set<Integer> visitedBus = new HashSet<>();

        Deque<Integer> q = new ArrayDeque<>();
        q.add(source);

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            res++;

            for (int i = 0; i < size; i++) {
                int cur = q.removeFirst();

                List<Integer> routeList = bus2Indexes.getOrDefault(cur, new ArrayList<>());
                for (Integer index : routeList) {
                    if (!visitedRoute.contains(index)) {
                        visitedRoute.add(index);

                        for (int bus : routes[index]) {
                            if (target == bus) {
                                return res;
                            }

                            if (!visitedBus.contains(bus)) {
                                visitedBus.add(bus);
                                q.addLast(bus);
                            }
                        }

                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Num_815 test = new Num_815();

        int[][] arr = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(test.numBusesToDestination(arr, 1, 6));
    }
}
