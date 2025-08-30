package org.example.auz.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 582. Kill Process
 */
public class Num_582_1 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            Integer parent = ppid.get(i);
            Integer child = pid.get(i);
            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        List<Integer> res = new ArrayList<>();
        dfs(graph, kill, res);
        return res;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int kill, List<Integer> res) {
        res.add(kill);
        if (graph.containsKey(kill)) {
            for (Integer child : graph.get(kill)) {
                dfs(graph, child, res);
            }
        }
    }
}
