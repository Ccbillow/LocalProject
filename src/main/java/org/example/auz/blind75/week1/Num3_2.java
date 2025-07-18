package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.ListNode;

/**
 * Merge Two Sorted Lists
 *
 * desc: https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class Num3_2 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }
}
