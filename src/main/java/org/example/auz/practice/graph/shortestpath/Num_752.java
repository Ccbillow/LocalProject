package org.example.auz.practice.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 752. open-the-lock
 * https://leetcode.cn/problems/open-the-lock/description/
 */
public class Num_752 {

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) return -1;
        if ("0000".equals(target)) return 0;

        Deque<String> q = new ArrayDeque<>();
        q.addLast("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();

                if (cur.equals(target)) {
                    return res;
                }

                for (String nei : neighbor(cur)) {
                    if (!dead.contains(nei) && !visited.contains(nei)) {
                        q.addLast(nei);
                        visited.add(nei);
                    }
                }
            }
            res++;
        }

        return -1;
    }

    private List<String> neighbor(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = arr[i];

            arr[i] = (c == '9') ? '0' : (char) (c + 1);
            res.add(new String(arr));

            arr[i] = (c == '0') ? '9' : (char) (c - 1);
            res.add(new String(arr));

            arr[i] = c;
        }
        return res;
    }
}
