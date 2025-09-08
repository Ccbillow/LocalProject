package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. palindrome-partitioning
 * https://leetcode.cn/problems/palindrome-partitioning/description/?show=1
 */
public class Num_131 {

    List<List<String>> res = new ArrayList<>();

    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                path.addLast(s.substring(i, j + 1));

                dfs(s, j + 1);

                path.removeLast();
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

    public static void main(String[] args) {
        Num_131 test = new Num_131();
        test.partition("aab");
    }

}
