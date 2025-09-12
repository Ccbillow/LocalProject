package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LCR 109. 打开转盘锁
 */
public class LCR_109 {

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            if ("0000".equals(deadend)) {
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

                for (String nei : neighbor(cur)) {
                    if (visited.contains(nei)) {
                        continue;
                    }

                    q.addLast(nei);
                    visited.add(nei);
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> neighbor(String cur) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            res.add(up(cur, i));
            res.add(down(cur, i));
        }
        return res;
    }

    private String down(String cur, int i) {
        char[] arr = cur.toCharArray();
        if (arr[i] == '0') {
            arr[i] = '9';
        } else {
            arr[i] = (char) (arr[i] - 1);
        }
        return String.valueOf(arr);
    }

    private String up(String cur, int i) {
        char[] arr = cur.toCharArray();
        if (arr[i] == '9') {
            arr[i] = '0';
        } else {
            arr[i] = (char) (arr[i] + 1);
        }
        return String.valueOf(arr);
    }
}
