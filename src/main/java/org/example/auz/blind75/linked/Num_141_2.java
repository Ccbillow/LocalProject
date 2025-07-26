package org.example.auz.blind75.linked;

import org.example.auz.blind75.tool.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 *  time: O(n)
 *  space: O(n)
 */
public class Num_141_2 {

    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> visited = new HashMap<>();

        while (head != null) {
            if (visited.containsKey(head)) {
                return true;
            }

            visited.put(head, true);
            head = head.next;
        }

        return false;
    }
}
