package org.example.auz.blind75.stack;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (operator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int tmp = calculate(a, b, token);
                stack.add(tmp);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean operator(String token) {
        return "+-*/".contains(token);
    }

    private int calculate(int a, int b, String token) {
        if ("+".equals(token)) {
            return a + b;
        } else if ("-".equals(token)) {
            return a - b;
        } else if ("*".equals(token)) {
            return a * b;
        } else if ("/".equals(token)) {
            return a / b;
        } else {
            throw new RuntimeException("not supporting.");
        }
    }
}
