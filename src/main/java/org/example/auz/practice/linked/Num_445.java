package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 445. Add Two Numbers II
 * https://leetcode.com/problems/add-two-numbers-ii/description/?show=1
 */
public class Num_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        Deque<Integer> resDeque = new ArrayDeque<>();

        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            d1.addLast(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            d2.addLast(p2.val);
            p2 = p2.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (!d1.isEmpty() || !d2.isEmpty() || carry != 0) {
            int val = carry;
            if (!d1.isEmpty()) {
                val = val + d1.pollLast();
            }
            if (!d2.isEmpty()) {
                val = val + d2.pollLast();
            }

            carry = val / 10;
            val = val % 10;
            resDeque.addLast(val);

        }
        while (!resDeque.isEmpty()) {
            Integer i = resDeque.pollLast();
            p.next = new ListNode(i);
            p = p.next;
        }
        return dummy.next;
    }
}
