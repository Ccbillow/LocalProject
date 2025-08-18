package org.example.auz.practice.queue;

/**
 * 622. Design Circular Queue
 * https://leetcode.com/problems/design-circular-queue/description/
 */
public class Num_622 {

    private int[] arr;
    private int size;
    private int count;
    private int head;


    public Num_622(int k) {
        arr = new int[k];
        size = k;
        count = 0;
        head = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        arr[(head + count) % size] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % size;
        count--;
        return true;
    }

    public int Front() {
        if (count == 0) return -1;
        return arr[head];
    }

    public int Rear() {
        if (count == 0) return -1;
        return arr[(head + count - 1) % size];
    }

    public boolean isEmpty() {
        return 0 == count;
    }

    public boolean isFull() {
        return count == size;
    }
}
