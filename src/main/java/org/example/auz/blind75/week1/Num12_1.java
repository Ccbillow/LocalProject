package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.ListNode;

/**
 * Linked List Cycle
 *
 * desc: https://leetcode.com/problems/linked-list-cycle/description/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Num12_1 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
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
