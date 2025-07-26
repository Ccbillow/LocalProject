package org.example.auz.blind75.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }

        if (list1 != null) {
            res.next = list1;
        } else if (list2 != null) {
            res.next = list2;
        }

        return tmp.next;
    }
}
