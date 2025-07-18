package org.example.interview.linked;

public class DeleteNode {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        if (node.next == null) {
            node = null;
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
