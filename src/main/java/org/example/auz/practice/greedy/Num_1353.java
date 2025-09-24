package org.example.auz.practice.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1353. maximum-number-of-events-that-can-be-attended
 * https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended/description/
 */
public class Num_1353 {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int lastDay = 0;
        for (int[] e : events) {
            lastDay = Math.max(lastDay, e[1]);
        }

        int day = 1;
        int i = 0;
        int res = 0;
        while (day <= lastDay) {
            while (i < events.length && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                res++;
                pq.poll();
            }

            day++;
        }

        return res;
    }

    public static void main(String[] args) {
        Num_1353 test = new Num_1353();
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        test.maxEvents(arr);
    }
}
