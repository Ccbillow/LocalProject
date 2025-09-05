package org.example.auz.practice.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 630. course-schedule-iii
 * https://leetcode.cn/problems/course-schedule-iii/description/
 */
public class Num_630 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        int total = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastday = course[1];
            total = total + duration;

            max.offer(duration);

            if (total > lastday) {
                total = total - max.poll();
            }
        }
        return max.size();
    }
}
