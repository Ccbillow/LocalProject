package org.example.auz.practice.graph.dfs;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 433. minimum-genetic-mutation
 *
 * https://leetcode.cn/problems/minimum-genetic-mutation/description/?show=1
 */
public class Num_433_2 {

    class Pair {
        String key;
        Integer value;

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Deque<Pair> stack = new ArrayDeque<>();
        stack.addLast(new Pair(startGene, 0));

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int min = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            Pair curPair = stack.removeLast();
            String cur = curPair.key;
            int step = curPair.value;

            if (cur.equals(endGene)) {
                min = Math.min(min, step);
                continue;
            }

            for (String nei : bank) {
                if (visited.contains(nei)) {
                    continue;
                }

                if (match(cur, nei)) {
                    visited.add(nei);
                    stack.addLast(new Pair(nei, step + 1));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean match(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}
