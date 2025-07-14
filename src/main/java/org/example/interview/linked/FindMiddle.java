package org.example.interview.linked;

public class FindMiddle {

    public static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.init();
        ListNode middle = findMiddle(head);
        System.out.println(middle.val);
    }
}
