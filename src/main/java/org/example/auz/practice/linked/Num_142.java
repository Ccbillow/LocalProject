package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 142. Linked List Cycle II
 * <p>
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 */
public class Num_142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // fast: 2k
        // slow: k
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
