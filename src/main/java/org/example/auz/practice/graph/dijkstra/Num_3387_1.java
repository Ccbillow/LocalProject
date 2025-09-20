package org.example.auz.practice.graph.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 3387. maximize-amount-after-two-days-of-conversions
 * <p>
 * https://leetcode.cn/problems/maximize-amount-after-two-days-of-conversions/description/
 */
public class Num_3387_1 {

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Map<String, Double>> graph1 = build(pairs1, rates1);
        Map<String, Map<String, Double>> graph2 = build(pairs2, rates2);

        Map<String, Double> maxRateDay1 = dijkstra(initialCurrency, graph1);

        double maxAmount = 0.0;
        for (String currency : maxRateDay1.keySet()) {
            Map<String, Double> maxRateDay2 = dijkstra(currency, graph2);
            if (maxRateDay2.containsKey(initialCurrency)) {
                Double amount = maxRateDay1.get(currency);
                maxAmount = Math.max(maxAmount, amount * maxRateDay2.get(initialCurrency));
            }
        }

        return maxAmount;
    }

    private Map<String, Double> dijkstra(String start, Map<String, Map<String, Double>> graph) {
        Map<String, Double> maxRates = new HashMap<>();

        PriorityQueue<Object[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double) b[1], (double) a[1]));
        pq.add(new Object[]{start, 1.0});
        maxRates.put(start, 1.0);

        while (!pq.isEmpty()) {
            Object[] cur = pq.poll();
            String currency = (String) cur[0];
            double currentRate = (double) cur[1];

            if (currentRate < maxRates.getOrDefault(currency, 0.0)) {
                continue;
            }

            for (Map.Entry<String, Double> neighbor : graph.getOrDefault(currency, new HashMap<>()).entrySet()) {
                String nei = neighbor.getKey();
                double neiRate = currentRate * neighbor.getValue();

                if (neiRate > maxRates.getOrDefault(nei, 0.0)) {
                    maxRates.put(nei, neiRate);
                    pq.add(new Object[]{nei, neiRate});
                }
            }
        }
        return maxRates;
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
