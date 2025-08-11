package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Num_206_1 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head.next;

        while (cur != null) {
            // reverse cur node
            cur.next = pre;

            // moving forward
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }

        return pre;
    }

    public ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head.next;
        while (n > 0) {
            cur.next = pre;

            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            n--;
        }

        // cur = n + 1, head is tail after reverse
        /*
           pre    head  cur  nxt
            3   2   1    4   5   6
         */
        head.next = cur;
        return pre;
    }

}
