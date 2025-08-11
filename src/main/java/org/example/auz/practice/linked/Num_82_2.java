package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_82_2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }

                fast = fast.next;
                if (fast == null) {
                    slow.next = null;
                }
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
