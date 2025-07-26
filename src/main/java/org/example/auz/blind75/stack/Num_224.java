package org.example.auz.blind75.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. Basic Calculator
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_224 {
    /*
        2+(1+(4+5+2)-3)+(6+8)
                   ^

        sum: 11
        num: 0
        sign:1
        stack: 2 + 1 +
     */
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        int num = 0;
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                sum = sum + num * sign;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                sum = sum + num * sign;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.addLast(sum);
                stack.addLast(sign);
                sum = 0;
                sign = 1;
            } else if (c == ')') {
                sum = sum + num * sign;
                sum = sum * stack.pollLast();
                sum = sum + stack.pollLast();
                num = 0;
            }
        }
        if (num != 0) {
            sum = sum + num * sign;
        }
        return sum;
    }
}
