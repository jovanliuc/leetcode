package leetcode.question0025;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        reverseKGroup(head, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a;
        ListNode b;
        a = head;
        b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode reversedListNode = reverseRange(a, b);
        a.next = reverseKGroup(b, k);
        return reversedListNode;
    }

    private ListNode reverseRange(ListNode a, ListNode b) {
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
