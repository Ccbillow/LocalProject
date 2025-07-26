package org.example.auz.blind75.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 *  time: O(n)
 *  space: O(1)
 */
public class Num_141_1 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
