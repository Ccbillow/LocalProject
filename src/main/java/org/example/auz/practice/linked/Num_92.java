package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 */
public class Num_92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }

        int i = 1;
        ListNode pre = head;
        while (pre != null && i < left - 1) {
            i++;
            pre = pre.next;
        }

        pre.next = reverseN(pre.next, right - left + 1);
        return head;
    }

    private static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head.next;

        while (n > 0) {
            n--;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }

        head.next = cur;
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(5);
        head.next = node;
        reverseBetween(head, 1, 2);
    }
}
