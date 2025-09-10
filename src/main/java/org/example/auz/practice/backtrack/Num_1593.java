package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 1593. split-a-string-into-the-max-number-of-unique-substrings
 *
 * https://leetcode.cn/problems/split-a-string-into-the-max-number-of-unique-substrings/description/
 */
public class Num_1593 {

    Deque<String> stack = new ArrayDeque<>();
    Set<String> set = new HashSet<>();

    int res = 0;

    public int maxUniqueSplit(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int idx) {
        if (idx == s.length()) {
            res = Math.max(res, stack.size());
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String cur = s.substring(idx, i + 1);

            if (set.contains(cur)) {
                continue;
            }

            stack.add(cur);
            set.add(cur);
            dfs(s, i + 1);
            stack.removeLast();
            set.remove(cur);
        }
    }

    public static void main(String[] args) {
        Num_1593 test = new Num_1593();
//        test.maxUniqueSplit("ababccc");
        test.maxUniqueSplit("abaac");
    }
}
