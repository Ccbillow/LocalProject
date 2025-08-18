package org.example.auz.practice.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 901. Online Stock Span
 * https://leetcode.com/problems/online-stock-span/description/?show=1
 */
public class Num_901 {

    Deque<int[]> stack;

    public Num_901() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;

        while (!stack.isEmpty() && price > stack.peekLast()[0]) {
            int[] pop = stack.pop();
            count = count + pop[1];
        }

        stack.addLast(new int[]{price, count});
        return count;
    }
}
