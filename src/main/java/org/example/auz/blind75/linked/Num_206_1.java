package org.example.auz.blind75.linked;

import org.example.auz.blind75.tool.ListNode;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * time: O(n)
 * space: O(1)
 */
public class Num_206_1 {

    /*
        [1,2,3,4,5]
           ^

         pre:1
         cur:null
         tmp:
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;

        }
        return pre;
    }
}
