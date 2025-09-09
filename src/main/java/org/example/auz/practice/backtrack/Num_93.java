package org.example.auz.practice.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. restore-ip-addresses
 * https://leetcode.cn/problems/restore-ip-addresses/description/
 */
public class Num_93 {

    List<String> res = new ArrayList<>();

    Deque<String> stack = new ArrayDeque<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int idx) {
        if (idx == s.length() && stack.size() == 4) {
            res.add(String.join(".", stack));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (!valid(s, idx, i)) {
                continue;
            }

            if (stack.size() > 4) {
                break;
            }
            stack.addLast(s.substring(idx, i + 1));
            dfs(s, i + 1);
            stack.removeLast();
        }
    }

    private boolean valid(String s, int left, int right) {
        int len = right - left + 1;
        if (len == 0 || len > 3) {
            return false;
        }
        if (len == 1) {
            return true;
        }
        if (s.charAt(left) == '0') {
            return false;
        }
        if (len <= 2) {
            return true;
        }
        if (Integer.parseInt(s.substring(left, left + len)) > 255) {
            return false;
        } else {
            return true;
        }
    }
}
