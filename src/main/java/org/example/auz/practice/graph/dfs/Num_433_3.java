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
public class Num_433_3 {

    int min = Integer.MAX_VALUE;
    Set<String> visited;

    public int minMutation(String startGene, String endGene, String[] bank) {

        visited = new HashSet<>();
        visited.add(startGene);

        dfs(startGene, endGene, bank, 0);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(String cur, String endGene, String[] bank, int step) {
        if (cur.equals(endGene)) {
            min = Math.min(min, step);
            return;
        }

        for (String nei : bank) {
            if (visited.contains(nei)) {
                continue;
            }

            if (match(cur, nei)) {
                visited.add(nei);
                dfs(nei, endGene, bank, step + 1);
                visited.remove(nei);
            }
        }
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
