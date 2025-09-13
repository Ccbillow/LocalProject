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
public class Num_126_1 {

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return new ArrayList<>();
        }

        Map<String, List<String>> parents = new HashMap<>();
        boolean found = bfs(beginWord, endWord, dict, parents);

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(path, parents, beginWord, endWord);
        }

        return res;
    }

    private boolean bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> parents) {
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Set<String> curLevelVisited = new HashSet<>();

        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();
            curLevelVisited.clear();

            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();
                char[] arr = cur.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;

                        arr[j] = c;
                        String nxt = String.valueOf(arr);

                        if (dict.contains(nxt) && !visited.contains(nxt)) {
                            if (!curLevelVisited.contains(nxt)) {
                                q.addLast(nxt);
                                curLevelVisited.add(nxt);
                            }

                            parents.computeIfAbsent(nxt, k -> new ArrayList<>()).add(cur);

                            if (nxt.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    arr[j] = old;
                }
            }
            visited.addAll(curLevelVisited);
        }
        return found;
    }

    private void backtrack(List<String> path, Map<String, List<String>> parents,
                           String beginWord, String word) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String p : parents.get(word)) {
            path.add(p);
            backtrack(path, parents, beginWord, p);
            path.remove(path.size() - 1);
        }
    }
}
