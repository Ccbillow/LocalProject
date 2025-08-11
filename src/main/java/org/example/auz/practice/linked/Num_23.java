package org.example.auz.practice.linked;

import org.example.auz.blind75.tool.ListNode;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * time: O(N log k)
 * space: O(k)
 *
 * k: lists.length
 * n: all nodes
 */
public class Num_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }


        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            p.next = cur;
            if (cur.next != null) {
                pq.add(cur.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
