package org.example.auz.practice.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 2127. maximum-employees-to-be-invited-to-a-meeting
 * https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/description/
 */
public class Num_2172 {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
            graph[i].add(favorite[i]);
        }

        //todo
        return 0;
    }
}
