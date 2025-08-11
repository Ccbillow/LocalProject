package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

public class Num_876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
