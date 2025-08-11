package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 141. Linked List Cycle
 * <p>
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class Num_141 {

    public boolean detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
