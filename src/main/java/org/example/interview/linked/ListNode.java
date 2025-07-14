package org.example.interview.linked;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public static ListNode init() {
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(8);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(6);
        ListNode five = new ListNode(1);
        ListNode six = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        return one;
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + "");
        print(node.next);
    }
}
