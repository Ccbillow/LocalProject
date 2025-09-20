package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 3387. maximize-amount-after-two-days-of-conversions
 * <p>
 * https://leetcode.cn/problems/maximize-amount-after-two-days-of-conversions/description/
 */
public class Num_3387_2 {

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Map<String, Double>> graph1 = build(pairs1, rates1);
        Map<String, Map<String, Double>> graph2 = build(pairs2, rates2);

        Map<String, Double> maxRateDay1 = bfs(initialCurrency, graph1);

        Map<String, Double> maxRateDay2 = new HashMap<>();
        for (String currency : maxRateDay1.keySet()) {
            Map<String, Double> day2Max = bfs(currency, graph2);
            for (Map.Entry<String, Double> entry : day2Max.entrySet()) {
                maxRateDay2.put(entry.getKey(),
                        Math.max(
                                maxRateDay2.getOrDefault(entry.getKey(), 0.0),
                                entry.getValue() * maxRateDay1.get(currency)));
            }

        }

        return maxRateDay2.getOrDefault(initialCurrency, 1.0);
    }

    private Map<String, Double> bfs(String start, Map<String, Map<String, Double>> graph) {
        Map<String, Double> maxValues = new HashMap<>();
        Deque<String> q = new ArrayDeque<>();
        q.add(start);
        maxValues.put(start, 1.0);

        while (!q.isEmpty()) {
            String cur = q.removeFirst();
            Double amount = maxValues.get(cur);

            if (!graph.containsKey(cur)) {
                continue;
            }

            for (Map.Entry<String, Double> neighbor : graph.get(cur).entrySet()) {
                String nei = neighbor.getKey();
                Double neiRate = neighbor.getValue();
                double newAmount = amount * neiRate;

                if (newAmount > maxValues.getOrDefault(nei, 0.0)) {
                    q.addLast(nei);
                    maxValues.put(nei, newAmount);
                }
            }
        }
        return maxValues;
    }


    private Map<String, Map<String, Double>> build(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < pairs.size(); i++) {
            List<String> pair = pairs.get(i);
            String from = pair.get(0);
            String to = pair.get(1);
            double rate = rates[i];

            graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, rate);
            graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, 1.0 / rate);
        }

        return graph;
    }


}
