package org.example.interview.map;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode 815
 */
public class Bus {

    // 1,2,7  3,6,7
    /* ^
        map: 1 - 0
            2 - 0
            7 - 0,1
            3 - 1
            6 - 1

            source: 1
            list : 0
            tmpBuses : 1,2,7
            tmpBus: 1

     */
    public static int bus(List<List<Integer>> routes, int source, int target) {
        int res = 0;
        // <bus, index<>>
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.size(); i++) {
            List<Integer> tmp = routes.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                map.putIfAbsent(tmp.get(j), new ArrayList<>());
                map.get(tmp.get(j)).add(i);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;

            for (int i = 0; i < size; i++) {
                Integer index = queue.poll();
                List<Integer> tmpBuses = map.get(index);
                for (Integer tmpBus : tmpBuses) {
                    if (visitedBuses.contains(tmpBus)) {
                        continue;
                    }
                    visitedBuses.add(tmpBus);


                    List<Integer> list = routes.get(tmpBus);
                    for (Integer integer : list) {
                        if (integer == target) {
                            return res;
                        }
                        if (!visited.contains(integer)) {
                            visited.add(integer);
                            queue.addLast(integer);
                        }
                    }
                }
            }
        }
        return -1;
    }


    public static int bus2(List<List<Integer>> routes, int source, int target) {
        // bus - index<>
        Map<Integer, List<Integer>> bus2Index = new HashMap<>();
        for (int i = 0; i < routes.size(); i++) {
            for (int j = 0; j < routes.get(i).size(); j++) {
                bus2Index.putIfAbsent(routes.get(i).get(j), new ArrayList<>());
                bus2Index.get(routes.get(i).get(j)).add(i);
            }
        }

        int res = 0;
        Queue<Integer> busQueue = new ArrayDeque<>();
        Set<Integer> busSet = new HashSet<>();
        Set<Integer> busIndexSet = new HashSet<>();
        busQueue.add(source);
        busSet.add(source);
        while (!busQueue.isEmpty()) {
            int size = busQueue.size();
            res++;

            for (int i = 0; i < size; i++) {
                Integer tmpBus = busQueue.poll();

                List<Integer> busIndexList = bus2Index.get(tmpBus);
                for (Integer busIndex : busIndexList) {
                    if (busIndexSet.contains(busIndex)) {
                        continue;
                    }
                    busIndexSet.add(busIndex);

                    List<Integer> buses = routes.get(busIndex);
                    for (Integer bus : buses) {
                        if (bus == target) {
                            return res;
                        }
                        if (!busSet.contains(bus)) {
                            busQueue.add(bus);
                            busSet.add(bus);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> routes = List.of(List.of(1, 2, 7), List.of(3, 6, 7));
        System.out.println(bus(routes, 1, 6));
        System.out.println(bus2(routes, 1, 6));
    }
}
