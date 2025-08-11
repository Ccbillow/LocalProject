package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/?show=1
 */
public class Num_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode l1 = head;
        ListNode l2 = head;
        for (int i = 0; i < 2; i++) {
            if (l2 == null) {
                return head;
            }
            l2 = l2.next;
        }

        ListNode newHead = reverseK(l1, 2);
        l1.next = swapPairs(l2);
        return newHead;
    }

    private ListNode reverseK(ListNode head, int n) {
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
}
