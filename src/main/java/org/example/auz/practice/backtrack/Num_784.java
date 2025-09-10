package org.example.auz.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 *
 * https://leetcode.cn/problems/letter-case-permutation/description/
 */
public class Num_784 {

    List<String> res = new ArrayList<>();

    StringBuilder stack = new StringBuilder();

    public List<String> letterCasePermutation(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int idx) {
        if (idx == s.length()) {
            res.add(stack.toString());
            return;
        }

        if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            stack.append(s.charAt(idx));
            dfs(s, idx + 1);
            stack.deleteCharAt(stack.length() - 1);
        } else {
            stack.append(Character.toLowerCase(s.charAt(idx)));
            dfs(s, idx + 1);
            stack.deleteCharAt(stack.length() - 1);

            stack.append(Character.toUpperCase(s.charAt(idx)));
            dfs(s, idx + 1);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
