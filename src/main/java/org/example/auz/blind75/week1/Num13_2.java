package org.example.auz.blind75.week1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stacks using Queue
 * <p>
 * https://leetcode.com/problems/implement-stack-using-queues/description/
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
public class Num13_2 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;


    public Num13_2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        queue1.add(x);

        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
