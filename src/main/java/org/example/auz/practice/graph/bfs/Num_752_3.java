package org.example.auz.practice.graph.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 752. open-the-lock
 * https://leetcode.cn/problems/open-the-lock/description/
 */
public class Num_752_3 {

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            if ("0000".equals(deadend)) {
                return -1;
            }
            visited.add(deadend);
        }

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add("0000");
        q2.add(target);

        int res = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> newq = new HashSet<>();

            for (String cur : q1) {
                if (q2.contains(cur)) {
                    return res;
                }

                for (String nei : neighbors(cur)) {
                    if (q2.contains(nei)) {
                        return res + 1;
                    }

                    if (!visited.contains(nei)) {
                        newq.add(nei);
                        visited.add(nei);
                    }
                }
            }

            res++;

            q1 = newq;
            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
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
