package org.example.auz.practice.arr;

import java.util.Arrays;

/**
 * 253. Meeting Rooms II
 */
public class Num_253_1 {

    public int minMeetingRooms(int[][] meetings) {
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(begin);
        Arrays.sort(end);

        int count = 0;

        int max = 0;
        int left = 0;
        int right = 0;

        while (left < n && right < n) {
            if (begin[left] < end[right]) {
                count++;
                left++;
            } else {
                count--;
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
