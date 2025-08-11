package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_82_1 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy1 = new ListNode(101);
        ListNode dummy2 = new ListNode(101);

        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if ((p.next != null && p.val == p.next.val) || p1.val == p.val) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }

            p = p.next;
            p1.next = null;
            p2.next = null;
        }
        return dummy2.next;
    }
}
