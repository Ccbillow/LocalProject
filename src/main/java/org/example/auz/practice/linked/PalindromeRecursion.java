package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

public class PalindromeRecursion {

    ListNode left;
    ListNode right;
    boolean res = true;

    boolean isPalindrome(ListNode head) {
        left = head;
        traverse(head);
        return res;
    }

    private void traverse(ListNode right) {
        if (right == null) {
            return;
        }

        traverse(right.next);

        if (left.val == right.val) {
            res = false;
        }
        left = left.next;
    }
}
