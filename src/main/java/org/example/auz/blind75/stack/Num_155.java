package org.example.auz.blind75.stack;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/description/
 */
public class Num_155 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public Num_155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty() && minStack.peek() < val) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
