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
public class Num_23_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

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
