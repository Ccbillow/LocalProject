package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_19_2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p1 = dummy;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        ListNode p2 = dummy;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
