package org.example.auz.practice.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 2770 – Maximum Number of Jumps to Reach the Last Index
 * https://leetcode.cn/problems/maximum-number-of-jumps-to-reach-the-last-index/description/
 */
public class Num_2770 {

    public int maximumJumps(int[] nums, int target) {
        int[] dist = new int[nums.length];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 0});

        int res = -1;

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int idx = cur[0];
            int step = cur[1];

            if (idx == nums.length - 1) {
                res = Math.max(res, step);
            }

            for (int i = idx + 1; i < nums.length; i++) {
                if (Math.abs(nums[i] - nums[idx]) <= target) {
                    if (dist[i] < step + 1) {
                        dist[i] = step + 1;
                        q.addLast(new int[]{i, step + 1});
                    }
                }
            }
        }
        return res;
    }
}
