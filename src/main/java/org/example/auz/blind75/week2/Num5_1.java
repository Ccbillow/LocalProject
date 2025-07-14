package org.example.auz.blind75.week2;

import org.example.interview.linked.ListNode;

/**
 * Reverse Linked List
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 *  * Time Complexity: O(n)
 *  * Space Complexity: O(1)
 */
public class Num5_1 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
