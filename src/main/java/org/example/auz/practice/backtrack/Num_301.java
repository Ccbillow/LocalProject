package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. 删除无效的括号
 *
 * https://leetcode.cn/problems/remove-invalid-parentheses/description/
 */
public class Num_301 {

    List<String> res = new ArrayList<>();
    StringBuilder stack = new StringBuilder();
    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0);

        int max = 0;
        for (String re : res) {
            max = Math.max(max, re.length());
        }
        Set<String> set = new HashSet<>();
        for (String re : res) {
            if (max == re.length()) {
                set.add(re);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(String s, int idx) {
        if (idx == s.length()) {
            if (valid(stack.toString())) {
                res.add(stack.toString());
            }
            return;
        }
        char c = s.charAt(idx);
        if (c != '(' && c != ')') {
            stack.append(c);
            dfs(s, idx + 1);
            stack.deleteCharAt(stack.length() - 1);
        } else {
            stack.append(c);
            dfs(s, idx + 1);
            stack.deleteCharAt(stack.length() - 1);

            dfs(s, idx + 1);
        }
    }

    private boolean valid(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
                if (left < 0) {
                    return false;
                }
            }
        }

        return left == 0;
    }
}
