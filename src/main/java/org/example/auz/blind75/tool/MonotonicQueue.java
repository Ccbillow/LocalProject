package org.example.auz.blind75.tool;

import java.util.LinkedList;

public class MonotonicQueue<E extends Comparable<E>>{
    LinkedList<E> q = new LinkedList<>();

    //head is max, tail is min
    LinkedList<E> maxq = new LinkedList<>();

    //head is min, tail is max
    LinkedList<E> minq = new LinkedList<>();

    public void push(E e) {
        q.addLast(e);

        while (!maxq.isEmpty() && maxq.getLast().compareTo(e) < 0) {
            maxq.pollLast();
        }
        maxq.addLast(e);

        while (!minq.isEmpty() && minq.getLast().compareTo(e) > 0) {
            minq.pollLast();
        }
        minq.addLast(e);
    }

    public E max() {
        return maxq.getFirst();
    }

    public E min() {
        return minq.getFirst();
    }

    public E pop() {
        E del = q.pollFirst();
        assert del != null;

        if (del.equals(maxq.getFirst())) {
            maxq.pollFirst();
        }
        if (del.equals(minq.getFirst())) {
            minq.pollFirst();
        }

        return del;
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
