package org.example.auz.blind75.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 *  time: O(n)
 *  space: O(1)
 */
public class Num_876_2 {

    public ListNode middleNode(ListNode head) {
        int len = length(head);
        int mid = len / 2;
        ListNode tmp = head;
        for (int i = 0; i < mid; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    private int length(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }
}
