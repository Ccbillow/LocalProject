package org.example.interview.linked;

public class Reverse {

    /**
     * 链表反转
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.init();
        ListNode.print(node);

        System.out.println();
        ListNode reverse = reverse(node);
        ListNode.print(reverse);
    }
}
