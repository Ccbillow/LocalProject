package org.example.auz.practice.backtrack;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1849. splitting-a-string-into-descending-consecutive-values
 * https://leetcode.cn/problems/splitting-a-string-into-descending-consecutive-values/description/
 */
public class Num_1849 {


    boolean res = false;
    Deque<BigInteger> stack = new ArrayDeque<>();

    public boolean splitString(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int idx)  {
        if (res) {
            return;
        }

        if (idx == s.length()) {
            if (stack.size() > 1) {
                res = true;
            }
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            BigInteger cur = new BigInteger(sub);

            if (stack.isEmpty() || stack.peekLast().subtract(cur).equals(BigInteger.ONE)) {
                stack.addLast(cur);
                dfs(s, i + 1);
                stack.removeLast();
            }

            // cut edge
            if (!stack.isEmpty() && cur.compareTo(stack.peekLast()) >= 0) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        Num_1849 test = new Num_1849();
        test.splitString("050043");
    }


}
