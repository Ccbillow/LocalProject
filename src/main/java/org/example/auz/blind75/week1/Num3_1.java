package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.ListNode;

/**
 * Merge Two Sorted Lists
 *
 * desc: https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class Num3_1 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


}
