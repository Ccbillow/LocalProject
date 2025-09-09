package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. palindrome-partitioning
 * https://leetcode.cn/problems/palindrome-partitioning/description/?show=1
 */
public class Num_131_1 {

    List<List<String>> res = new ArrayList<>();

    Deque<String> stack = new ArrayDeque<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                stack.addLast(s.substring(idx, i + 1));
                dfs(s, i + 1);
                stack.removeLast();
            }
        }
    }


    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }


}
