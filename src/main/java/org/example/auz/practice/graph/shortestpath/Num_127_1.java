package org.example.auz.practice.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. word-ladder
 * https://leetcode.cn/problems/word-ladder/description/
 */
public class Num_127_1 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Deque<String> q = new ArrayDeque<>();
        q.addLast(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int res = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();

                if (cur.equals(endWord)) {
                    return res;
                }

                for (String nei : wordList) {
                    if (!visited.contains(nei) && check(cur, nei)) {
                        visited.add(nei);
                        q.addLast(nei);
                    }
                }
            }
            res++;
        }
        return 0;
    }

    private boolean check(String cur, String nei) {
        int res = 0;

        char[] curChar = cur.toCharArray();
        char[] neiChar = nei.toCharArray();
        for (int i = 0; i < cur.toCharArray().length; i++) {
            if (curChar[i] != neiChar[i]) {
                res++;
            }
            if (res > 1) {
                return false;
            }
        }

        return res == 1;
    }

    public static void main(String[] args) {
        Num_127_1 test = new Num_127_1();

        List<String> wordlist = List.of("hot", "dot", "dog", "lot", "log", "cog");
//        System.out.println(test.ladderLength("hit", "cog", wordlist));

        List<String> wordlist1 = List.of("lest","leet","lose","code","lode","robe","lost");
//        System.out.println(test.ladderLength("leet", "code", wordlist1));

        List<String> wordlist2 = List.of("hot","dot","tog","cog");
        System.out.println(test.ladderLength("hit", "cog", wordlist2));

    }

}
