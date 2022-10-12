package datastructure.linkedlist;

import org.junit.jupiter.api.Test;

public class Solution8 {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reverseRange(head.next, head.next.next.next);
    }

    ListNode reverseRange(ListNode a, ListNode b) {
        ListNode previous = null;
        ListNode current = a;
        ListNode next = a;
        while (current != b) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
