package org.example.auz.practice.graph.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 399. Evaluate Division
 *
 * https://leetcode.com/problems/evaluate-division/description/
 */
public class Num_399_2 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double weight = values[i];
            set.add(from);
            set.add(to);
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Pair(to, weight));
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new Pair(from, 1.0 / weight));
        }

        double[] res = new double[queries.size()];
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if (!set.contains(from) || !set.contains(to)) {
                res[i] = -1.0;
            } else {
                res[i] = dfs(graph, from, to, visited, 1.0);
            }
            visited.clear();
        }

        return res;
    }

    private double dfs(Map<String, List<Pair>> graph, String start, String target, Set<String> visited, double val) {
        if (visited.contains(start)) {
            return -1.0;
        }
        if (start.equals(target)) {
            return val;
        }

        visited.add(start);
        for (Pair pair : graph.get(start)) {
            double res = dfs(graph, pair.key, target, visited, val * pair.value);
            if (res != -1.0) {
                return res;
            }
        }
        return -1;
    }


    class Pair {
        String key;
        double value;

        public Pair(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Num_399_2 test = new Num_399_2();

        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"));

        test.calcEquation(equations, values, queries);
    }
}
