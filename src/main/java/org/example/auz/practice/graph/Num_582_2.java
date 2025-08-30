package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode 582. Kill Process
 */
public class Num_582_2 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            Integer parent = ppid.get(i);
            Integer child = pid.get(i);
            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(kill);

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();
            res.add(cur);
            if (graph.containsKey(cur)) {
                q.addAll(graph.get(cur));
            }
        }
        return res;
    }

}
