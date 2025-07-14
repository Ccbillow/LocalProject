package org.example.auz.blind75.week1;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * <p>
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 * <p>
 * Time complexity:
 *      push - O(N)
 *      Pop  - O(1)
 *      Peek - O(1)
 *      isEmpty - O(1)
 * Space complexity:
 *      push - O(N)
 *      Pop  - O(1)
 *      Peek - O(1)
 *      isEmpty - O(1)
 */
public class Num13_1 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;


    public Num13_1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
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
