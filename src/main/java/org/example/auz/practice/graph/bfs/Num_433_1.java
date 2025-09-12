package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 433. minimum-genetic-mutation
 *
 * https://leetcode.cn/problems/minimum-genetic-mutation/description/?show=1
 */
public class Num_433_1 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Deque<String> q = new ArrayDeque<>();
        q.addLast(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();

                if (cur.equals(endGene)) {
                    return res;
                }

                for (String nei : bank) {
                    if (visited.contains(nei)) {
                        continue;
                    }

                    if (match(nei, cur)) {
                        q.addLast(nei);
                        visited.add(nei);
                    }
                }
            }
            res++;
        }
        return -1;
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
