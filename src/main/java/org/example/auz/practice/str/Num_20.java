package org.example.auz.practice.str;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class Num_20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else {
                if (!stack.isEmpty() && stack.peekLast() == getLeft(c)) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    char getLeft(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        return '}';
    }

    boolean match(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                left--;
                if (left < 0) {
                    return false;
                }
            }
        }
        return left == 0;

    }
}
