package org.example.auz.practice.graph.bfs;

import org.example.auz.practice.graph.shortestpath.Num_127;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/description/?show=1
 */
public class Num_127_3 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int res = 1;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;

                Set<String> tmpv = visited1;
                visited1 = visited2;
                visited2 = tmpv;
            }

            Set<String> newq = new HashSet<>();

            for (String cur : q1) {
                for (String candicate : dict) {
                    if (visited1.contains(candicate)) {
                        continue;
                    }

                    if (match(candicate, cur)) {
                        if (visited2.contains(candicate)) {
                            return res + 1;
                        }

                        newq.add(candicate);
                        visited1.add(candicate);
                    }
                }
            }

            q1 = newq;
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
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        Num_127_3 test = new Num_127_3();

        List<String> wordlist = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(test.ladderLength("hit", "cog", wordlist));

        List<String> wordlist1 = List.of("lest","leet","lose","code","lode","robe","lost");
//        System.out.println(test.ladderLength("leet", "code", wordlist1));

//        List<String> wordlist2 = List.of("hot","dot","tog","cog");
//        System.out.println(test.ladderLength("hit", "cog", wordlist2));

    }
}
