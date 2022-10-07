package leetcode.question0002;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);

        addTwoNumbers(l1, l2);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode header = new ListNode(0);
        ListNode current = header;

        int val1;
        int val2;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            int currentBitNumber = sum % 10;
            current.next = new ListNode(currentBitNumber);
            current = current.next;
            carry = sum / 10;
        }

        return header.next;
    }
}
