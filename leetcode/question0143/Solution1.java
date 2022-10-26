package leetcode.question0143;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
    }

    public void reorderList(ListNode head) {
        ListNode midNode = midNode(head);
        ListNode l1 = head;
        ListNode l2 = midNode.next;
        midNode.next = null;
        l2 = reverse(l2);
        merge(l1, l2);
    }

    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode curL1;
        ListNode curL2;
        while (l1 != null && l2 != null) {
            curL1 = l1.next;
            curL2 = l2.next;
            l1.next = l2;
            l1 = curL1;
            l2.next = l1;
            l2 = curL2;
        }
    }
}
