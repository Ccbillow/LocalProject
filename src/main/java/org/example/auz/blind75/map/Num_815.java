package org.example.auz.blind75.map;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 815. Bus Routes
 * https://leetcode.com/problems/bus-routes/description/
 *
 * time: O(n * m)
 * space: O(n)
 */
public class Num_815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> bus2Routes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] buses = routes[i];
            for (int bus : buses) {
                bus2Routes.putIfAbsent(bus, new ArrayList<>());
                bus2Routes.get(bus).add(i);
            }
        }

        int res = 0;
        Deque<Integer> busQueue = new ArrayDeque<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        Set<Integer> visitedBus = new HashSet<>();
        busQueue.addLast(source);
        while (!busQueue.isEmpty()) {
            res++;
            int size = busQueue.size();

            for (int i = 0; i < size; i++) {
                Integer bus = busQueue.pollFirst();

                List<Integer> routeList = bus2Routes.getOrDefault(bus, new ArrayList<>());
                for (Integer route : routeList) {
                    if (visitedRoutes.contains(route)) {
                        continue;
                    }

                    visitedRoutes.add(route);
                    int[] buses = routes[route];
                    for (int tmpBus : buses) {
                        if (target == tmpBus) {
                            return res;
                        }

                        if (!visitedBus.contains(tmpBus)) {
                            visitedBus.add(tmpBus);
                            busQueue.addLast(tmpBus);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
