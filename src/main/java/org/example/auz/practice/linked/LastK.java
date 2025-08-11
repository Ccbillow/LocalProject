package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * find last k node
 */
public class LastK {

    // 1 2 3 4 5
    // k = 2
    // 4
    // 5 - 2 + 1 = 4
    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 -> k
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        // p1, p2 -> n - k
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // p2 (n-k+1)
        return p2;
    }

}
