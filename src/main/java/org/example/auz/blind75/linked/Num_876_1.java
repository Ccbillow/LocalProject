package org.example.auz.blind75.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 *  time: O(n)
 *  space: O(1)
 */
public class Num_876_1 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
