package leetcode.question0143;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    void test() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(6);
        reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (i == j) {
                break;
            }
            list.get(i++).next = list.get(j);
            list.get(j--).next = list.get(i);
        }
        list.get(i).next = null;
    }
}
