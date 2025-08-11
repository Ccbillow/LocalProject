package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/description/
 *
 * time: O(n)
 * space: O(n)
 */
public class Num_61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        k = k % len;
        if (k == 0) return head;

        ListNode reverse = reverse(head);

        ListNode part1 = reverse;
        ListNode part1tail = reverse;
        for (int i = 1; i < k; i++) {
            part1tail = part1tail.next;
        }
        ListNode part2 = part1tail.next;
        part1tail.next = null;


        part1 = reverse(part1);
        part2 = reverse(part2);

        ListNode tmp = part1;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = part2;

        return part1;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        rotateRight(node1, 2);
    }
}
