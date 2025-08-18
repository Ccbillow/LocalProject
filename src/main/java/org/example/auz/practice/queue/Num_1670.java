package org.example.auz.practice.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 1670. Design Front Middle Back Queue
 * https://leetcode.com/problems/design-front-middle-back-queue/description/
 */
public class Num_1670 {

    private LinkedList<Integer> left;
    private LinkedList<Integer> right;

    public Num_1670() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    private void balance() {
        while (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }
        while (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        left.addLast(val);
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        int val;
        if (!left.isEmpty()) {
            val = left.removeFirst();
        } else {
            val = right.removeFirst();
        }
        balance();
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int val = left.removeLast();
        balance();
        return val;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        int val;
        if (!right.isEmpty()) {
            val = right.removeLast();
        } else {
            val = left.removeLast();
        }
        balance();
        return val;
    }

    public static void main(String[] args) {
        Num_1670 test = new Num_1670();
        test.pushFront(1);
        test.pushBack(2);
        test.pushMiddle(3);
        test.pushMiddle(4);
        System.out.println(test.popFront());
        System.out.println(test.popMiddle());
        System.out.println(test.popMiddle());
        System.out.println(test.popBack());
        System.out.println(test.popFront());
    }
}
