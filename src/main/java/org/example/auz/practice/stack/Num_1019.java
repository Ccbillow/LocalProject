package org.example.auz.practice.stack;

import org.example.auz.blind75.tool.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1019. Next Greater Node In Linked List
 * https://leetcode.com/problems/next-greater-node-in-linked-list/description/?show=1
 */
public class Num_1019 {

    public int[] nextLargerNodes(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        int[] res = new int[length];

        p = reverse(head);
        Deque<Integer> stack = new ArrayDeque<>();
        while (p != null) {
            while (!stack.isEmpty() && stack.peekLast() <= p.val) {
                stack.removeLast();
            }

            res[length - 1] = stack.isEmpty() ? 0 : stack.peekLast();
            length--;
            stack.addLast(p.val);
            p = p.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
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
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Num_1019 test = new Num_1019();
        test.nextLargerNodes(head);
    }
}
