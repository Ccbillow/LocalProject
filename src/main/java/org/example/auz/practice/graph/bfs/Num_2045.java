package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 2045. second-minimum-time-to-reach-destination
 * https://leetcode.cn/problems/second-minimum-time-to-reach-destination/
 */
public class Num_2045 {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        first[1] = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curNode = q.poll();
                int cur = curNode[0];
                int timeFromDist = curNode[1];

                for (int nei : graph[cur]) {
                    int wait = 0;
                    if ((timeFromDist / change) % 2 == 1) {
                        wait = change - (timeFromDist % change);
                    }

                    int arrive = timeFromDist + wait + time;

                    if (arrive < first[nei]) {
                        second[nei] = first[nei];
                        first[nei] = arrive;
                        q.add(new int[]{nei, arrive});
                    } else if (arrive > first[nei] && arrive < second[nei]) {
                        second[nei] = arrive;
                        q.add(new int[]{nei, arrive});
                    }
                }
            }
        }
        return second[n];
    }

    public static void main(String[] args) {
        Num_2045 test = new Num_2045();

        int[][] arr = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        System.out.println(test.secondMinimum(5, arr, 3, 5));

        int[][] arr1 = {{1, 2}};
        System.out.println(test.secondMinimum(2, arr1, 3, 2));
    }
}
