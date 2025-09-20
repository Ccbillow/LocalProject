package org.example.auz.practice.greedy;

import java.util.Arrays;

/**
 * 2279. maximum-bags-with-full-capacity-of-rocks
 * https://leetcode.cn/problems/maximum-bags-with-full-capacity-of-rocks/description/
 */
public class Num_2279 {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] needs = new int[n];
        for (int i = 0; i < n; i++) {
            needs[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(needs);

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks - needs[i] < 0) {
                break;
            }

            additionalRocks = additionalRocks - needs[i];
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Num_2279 test = new Num_2279();
        int[] capacity = {10,2,2};
        int[] rocks = {2,2,0};
        test.maximumBags(capacity, rocks, 100);
    }
}
