package org.example.auz.practice.arr;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 */
public class Num_253_3 {

    public int minMeetingRooms(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] m : meetings) {
            if (!pq.isEmpty() && m[0] > pq.peek()) {
                pq.poll();
            }

            pq.add(m[1]);
        }

        return pq.size();
    }


}
