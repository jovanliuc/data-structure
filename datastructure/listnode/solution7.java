package datastructure.listnode;

import org.junit.jupiter.api.Test;

public class solution7 {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reverse(head);
    }

    ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
