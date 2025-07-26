package org.example.auz.blind75.stack;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 *  time: O(n)
 *  space: O(n)
 */
public class Num_232 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Num_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        stack1.add(x);
        while (!stack2.isEmpty()) {
            stack1.add(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
