package org.example.auz.practice.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/description/
 */
public class Num_239 {

    class MonotonicQueue {

        private LinkedList<Integer> Q = new LinkedList<>();
        private LinkedList<Integer> maxQ = new LinkedList<>();


        void push(int n) {
            Q.addLast(n);

            while (!maxQ.isEmpty() && n > maxQ.peekLast()) {
                maxQ.removeLast();
            }
            maxQ.addLast(n);
        }

        int max() {
            return maxQ.peekFirst();
        }

        void pop() {
            Integer i = Q.peekFirst();
            assert i != null;

            if (maxQ.peekFirst().equals(i)) {
                maxQ.removeFirst();
            }
            Q.removeFirst();
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                list.add(queue.max());
                queue.pop();
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
