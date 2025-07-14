package org.example.auz.blind75.week1;

import org.example.auz.blind75.tool.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Linked List Cycle
 *
 * desc: https://leetcode.com/problems/linked-list-cycle/description/
 *
 * Time Complexity: O(n), since each node is visited once.
 * Space Complexity: O(n), as we use a HashSet to store visited nodes.
 */
public class Num12_2 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
