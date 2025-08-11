package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class Num_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a = head;
        ListNode b = head;

        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverseN(a, k);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverseN(ListNode a, int k) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a.next;

        while (k > 0) {
            k--;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }

        // 1    2   3   4   5
        // pre      a  cur
        // 3    2   1   4   5
        a.next = cur;

        return pre;
    }


}
