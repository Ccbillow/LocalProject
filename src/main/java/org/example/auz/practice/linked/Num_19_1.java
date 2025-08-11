package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class Num_19_1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;

        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        if (p1 == null) {
            return head.next;
        }

        ListNode p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return head;
    }
}
