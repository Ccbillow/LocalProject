package org.example.auz.blind75.week2;

import org.example.auz.blind75.tool.ListNode;

/**
 * Middle of the Linked List
 * <p>
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 *  *  * Time Complexity: O(n)
 *  *  * Space Complexity: O(1)
 */
public class Num9 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
