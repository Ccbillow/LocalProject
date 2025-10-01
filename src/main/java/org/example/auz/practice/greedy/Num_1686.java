package org.example.auz.practice.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1686. stone-game-vi
 * https://leetcode.cn/problems/stone-game-vi/description/
 */
public class Num_1686 {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;

        TreeMap<Integer, LinkedList<Integer>> val2Indexes = new TreeMap<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            val2Indexes.computeIfAbsent(aliceValues[i] + bobValues[i], k -> new LinkedList<>()).addLast(i);
        }

        int scoreA = 0;
        int scoreB = 0;

        boolean alice = true;
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, LinkedList<Integer>> entry = val2Indexes.firstEntry();
            LinkedList<Integer> indexes = entry.getValue();
            Integer idx = indexes.removeFirst();

            if (indexes.isEmpty()) {
                val2Indexes.pollFirstEntry();
            }

            if (alice) {
                scoreA += aliceValues[idx];
            } else {
                scoreB += bobValues[idx];
            }

            alice = !alice;
        }

        if (scoreA == scoreB) {
            return 0;
        }
        return scoreA > scoreB ? 1 : -1;
    }

    public static void main(String[] args) {
        Num_1686 test = new Num_1686();
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {1, 6, 7};

        test.stoneGameVI(arr1, arr2);
    }
}
