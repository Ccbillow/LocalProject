package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/description/?show=1
 */
public class Num_127_2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();

        Deque<String> q = new ArrayDeque<>();
        q.addLast(beginWord);
        visited.add(beginWord);

        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();

                if (cur.equals(endWord)) {
                    return res;
                }

                for (String nei : wordList) {
                    if (visited.contains(nei)) {
                        continue;
                    }

                    if (match(cur, nei)) {
                        visited.add(nei);
                        q.addLast(nei);
                    }
                }
            }
            res++;
        }
        return 0;
    }

    private boolean match(String a, String b) {
        int diff = 0;
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
