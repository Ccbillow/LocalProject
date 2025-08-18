package org.example.auz.practice.queue;

/**
 * 641. Design Circular Deque
 * https://leetcode.com/problems/design-circular-deque/description/
 */
public class Num_641 {

    private int[] arr;
    private int size;
    private int count;
    private int head;

    public Num_641(int k) {
        arr = new int[k];
        size = k;
        count = 0;
        head = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        head = (this.head - 1 + size) % size;
        arr[head] = value;
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        arr[(head + count) % size] = value;
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % size;
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        count--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[head];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[(head + count - 1) % size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}
