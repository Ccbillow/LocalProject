package org.example.auz.blind75.linked;

import org.example.auz.blind75.tool.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_206_2 {

    public ListNode reverseList(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }

        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (!stack.isEmpty()) {
            tmp.next = new ListNode(stack.pollLast());
            tmp = tmp.next;
        }
        return res.next;
    }
}
