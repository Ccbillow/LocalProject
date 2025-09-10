package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 752. open-the-lock
 * https://leetcode.cn/problems/open-the-lock/description/
 */
public class Num_752_2 {

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            if (deadend.equals("0000")) {
                return -1;
            }
            visited.add(deadend);
        }

        Deque<String> q = new ArrayDeque<>();
        q.addLast("0000");
        visited.add("0000");

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();

                if (cur.equals(target)) {
                    return res;
                }

                for (String nei : neighbors(cur)) {
                    if (!visited.contains(nei)) {
                        q.addLast(nei);
                        visited.add(nei);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> neighbors(String cur) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            res.add(plusOne(cur, i));
            res.add(minusOne(cur, i));
        }
        return res;
    }

    private String minusOne(String cur, int i) {
        char[] arr = cur.toCharArray();
        if (arr[i] == '0') {
            arr[i] = '9';
        } else {
            arr[i] = (char) (arr[i] - 1);
        }
        return String.valueOf(arr);
    }

    private String plusOne(String cur, int i) {
        char[] arr = cur.toCharArray();
        if (arr[i]=='9'){
            arr[i] = '0';
        } else {
            arr[i] = (char) (arr[i] + 1);
        }
        return String.valueOf(arr);
    }
}
