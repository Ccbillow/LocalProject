package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Num_83 {

    /*
        1  2  2  3  5
        ^^
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }
        return head;
    }
}
