package org.example.auz.practice.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 126. word-ladder-ii
 * https://leetcode.cn/problems/word-ladder-ii/description/
 */
public class Num_126_2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return new ArrayList<>();
        }

        Map<String, List<String>> parent = new HashMap<>();
        boolean found = bfs(beginWord, endWord, dict, parent);

        List<List<String>> res = new ArrayList<>();
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(res, path, parent, beginWord, endWord);
        }
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> path,
                           Map<String, List<String>> parent, String beginWord, String word) {
        if (word.equals(beginWord)) {
            List<String> tmp = new ArrayList<>(path);
            Collections.reverse(tmp);
            res.add(tmp);
            return;
        }

        if (!parent.containsKey(word)) {
            return;
        }

        for (String p : parent.get(word)) {
            path.add(p);
            backtrack(res, path, parent, beginWord, p);
            path.remove(path.size() - 1);
        }

    }

    private boolean bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> parent) {
        Deque<String> q = new ArrayDeque<>();
        q.addLast(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean res = false;

        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();

                for (String nei : neighbors(cur)) {
                    if (dict.contains(nei) && !visited.contains(nei)) {
                        if (!levelVisited.contains(nei)) {
                            levelVisited.add(nei);
                            q.addLast(nei);
                        }

                        parent.computeIfAbsent(nei, k -> new ArrayList<>()).add(cur);

                        if (nei.equals(endWord)) {
                            res = true;
                        }
                    }
                }
            }
            visited.addAll(levelVisited);
        }
        return res;
    }

    List<String> neighbors(String s) {
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        for (int i = 0; i < sb.length(); i++) {
            StringBuilder tmp = new StringBuilder(sb);

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == sb.charAt(i)) {
                    continue;
                }

                tmp.setCharAt(i, ch);
                res.add(String.valueOf(tmp));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Num_126_2 test = new Num_126_2();
//        test.neighbors("bot");
    }


}
