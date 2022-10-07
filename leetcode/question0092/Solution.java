package leetcode.question0092;

import org.junit.jupiter.api.Test;

public class Solution {

    ListNode successor;

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
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode reversedListNode = reverseBetween(head, 3, 6);
        System.out.println(reversedListNode.val);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            ListNode last =  reverseN(head, right);
            return last;
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
