package org.example.interview.map;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * the shortest amount of transfers (or hops), from a given origin and destination.
 */
public class TransferTest {


    public static int transfer(List<List<Integer>> connections, int origin, int destination, List<List<Integer>> bannedList) {
        /*

            0 - 1,2,3
            1 - 2
            2 - 3
            3 - ...

            origin: 0
            destination: 3

            from = 0
            toList = [1,2,3]
            fromQueue = [1,2,3]

            from = 1
            toList = [2]
            fromQueue = [2,3]

            from = 2
            toList = [3]
            fromQueue = [3]

         */
        // from(0) - to[1,2,3]
        // from(1) - to[2]
        Map<Integer, List<Integer>> from2ToList = new HashMap<>();
        for (int i = 0; i < connections.size(); i++) {
            from2ToList.put(i, connections.get(i));
        }

        int res = 0;
        // visited city, avoid cycles
        Set<Integer> visited = new HashSet<>();
        Set<Integer> banned = new HashSet<>();
        // from city, bfs
        Deque<Integer> fromQueue = new ArrayDeque<>();

        fromQueue.add(origin);
        visited.add(origin);

        while (!fromQueue.isEmpty()) {
            int size = fromQueue.size();
            res++;

            // current level
            for (int i = 0; i < size; i++) {
                Integer from = fromQueue.pollFirst();

                // from(0) - to[1,2,3]
                List<Integer> toList = from2ToList.get(from);
                List<Integer> curBanned = bannedList.get(from) == null ? new ArrayList<>() : bannedList.get(from);

                // add global banned
                if (curBanned != null && !curBanned.isEmpty()) {
                    banned.addAll(curBanned);
                }

                // go through toList, if equals destination then return
                for (Integer to : toList) {
                    // check banned
                    if (banned.contains(to)) {
                        continue;
                    }

                    if (to == destination) {
                        return res;
                    }

                    if (!visited.contains(to)) {
                        visited.add(to);
                        fromQueue.add(to);
                    }
                }
            }
        }

        return -1;
    }

    private static void test(int testCaseNumber, int expected, List<List<Integer>> connections,
                             int origin, int destination, List<List<Integer>> bannedList) {
        int result = transfer(connections, origin, destination, bannedList);
        if (result == expected) {
            System.out.println("Test " + testCaseNumber + " passed: " + result);
        } else {
            System.out.println("Test " + testCaseNumber + " failed: expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        // 0 -> 3
        // 0 -> 1 -> 2 -> 3
        // 0 -> 2 -> 3
        // 1
        test(1, 1, List.of(List.of(1, 2, 3), List.of(2), List.of(3), new ArrayList<>()),
                0, 3, List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));


        // 0 -> 2 -> 3
        // 0 -> 1 -> 2 -> 3
        // 2
        test(2, 2, List.of(List.of(1, 2), List.of(2), List.of(3), new ArrayList<>()),
                0, 3, List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        // 0 -> 1 -> 2 -> 3
        // 3
        test(3, 3, List.of(List.of(1), List.of(2), List.of(3), new ArrayList<>()),
                0, 3, List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));


        // forbid 3
        // -1
        test(4, -1, List.of(List.of(1, 2, 3), List.of(2), List.of(3), new ArrayList<>()),
                0, 3, List.of(List.of(3), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        // forbid 3
        // 0 -> 1 -> 3
        // 0 -> 2 -> 3
        // 2
        /*
            0 -> 1
            0 -> 2
            1 -> 3
            2 -> 3
         */
        test(5, 2, List.of(List.of(1, 2), List.of(3), List.of(3), new ArrayList<>()),
                0, 3, List.of(new ArrayList<>(), List.of(2), new ArrayList<>(), new ArrayList<>()));


        // 0 -> 1 -> 2 -> 3 forbid
        // 0 -> 1 -> 3 forbid
        // 0 -> 2 -> 3 forbid
        // -1
        /*
            0 -> 1
            0 -> 2
            1 -> 2
            1 -> 3
            2 -> 3
         */
        test(6, -1, List.of(List.of(1, 2), List.of(2, 3), List.of(3), new ArrayList<>()),
                0, 3, List.of(List.of(3), new ArrayList<>(), List.of(1), new ArrayList<>()));

        // 1 -> 2 -> 4
        // 1 -> 3 -> 4
        // 2
        /*
            1 -> 2
            1 -> 3
            2 -> 4
            3 -> 4
         */
        test(7, 2, List.of(new ArrayList<>(), List.of(2, 3), List.of(4), List.of(4), new ArrayList<>()),
                1, 4, List.of(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        // 1 -> 2 -> 4
        // 1 -> 3 -> 4 forbid
        // 2
        /*
            1 -> 2
            1 -> 3
            2 -> 4
            3 -> 4
         */
        test(8, 2, List.of(new ArrayList<>(), List.of(2, 3), List.of(4), List.of(4), new ArrayList<>()),
                1, 4, List.of(new ArrayList<>(), List.of(3), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        // 1 -> 2 -> 4 forbid
        // 1 -> 3 -> 4 forbid
        // -1
        /*
            1 -> 2
            1 -> 3
            2 -> 4
            3 -> 4
         */
        test(9, -1, List.of(new ArrayList<>(), List.of(2, 3), List.of(4), List.of(4), new ArrayList<>()),
                1, 4, List.of(new ArrayList<>(), List.of(4), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        // 1 -> 2 -> 4 forbid
        // 1 -> 3 -> 5
        // 2
        /*
            1 -> 2
            1 -> 3
            2 -> 4
            3 -> 5
         */
        test(10, 2, List.of(new ArrayList<>(), List.of(2, 3), List.of(4), List.of(5), new ArrayList<>(), new ArrayList<>()),
                1, 5, List.of(new ArrayList<>(), List.of(2), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));


        // 1 -> 2 -> 4 forbid
        // 1 -> 3 -> 4
        // 2
        /*
            1 -> 2
            1 -> 3
            2 -> 4
            3 -> 4
         */
        test(11, 2, List.of(new ArrayList<>(), List.of(2, 3), List.of(4), List.of(4), new ArrayList<>()),
                1, 4, List.of(new ArrayList<>(), List.of(2), List.of(4), new ArrayList<>(), new ArrayList<>()));

        // 0 -> 1 -> 2 -> 0
        /*
            0 -> 1
            1 -> 2
            2 -> 0
         */
        test(12, 2, List.of(List.of(1), List.of(2), List.of(0)),
                0, 2, List.of(new ArrayList<>(), new ArrayList<>(),new ArrayList<>()));
    }
}

