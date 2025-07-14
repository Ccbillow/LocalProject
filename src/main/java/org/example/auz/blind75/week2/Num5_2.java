package org.example.auz.blind75.week2;

import org.example.interview.linked.ListNode;

import java.util.Stack;

/**
 * Reverse Linked List
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 *  * Time Complexity: O(n)
 *  * Space Complexity: O(n)
 */
public class Num5_2 {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!stack.isEmpty()) {
            curr.next = new ListNode(stack.pop());
            curr = curr.next;
        }

        return dummy.next;
    }
}
