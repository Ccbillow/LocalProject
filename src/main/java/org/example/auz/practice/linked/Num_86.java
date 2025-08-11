package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/description/
 */
public class Num_86 {

    //Input: head = [1,4,3,2,5,2], x = 3
    //Output: [1,2,2,4,3,5]
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }

            // could be cycle
//            p = p.next;

            // break origin link
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }

        p1.next = dummy2.next;
        return dummy1.next;
    }
}
