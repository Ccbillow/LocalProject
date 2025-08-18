package org.example.auz.practice.queue;

import java.util.LinkedList;

/**
 * 2073. Time Needed to Buy Tickets
 * https://leetcode.com/problems/time-needed-to-buy-tickets/description/
 */
public class Num_2073 {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int ticket : tickets) {
            queue.addLast(ticket);
        }

        while (!queue.isEmpty()) {
            Integer first = queue.pollFirst();
            res++;

            if (first == 1 && k == 0) {
                return res;
            }

            if (first > 1) {
                queue.addLast(first - 1);
            }
            k--;
            if (k < 0) {
                k = queue.size() - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};
        System.out.println(timeRequiredToBuy(tickets, 2));
    }
}
