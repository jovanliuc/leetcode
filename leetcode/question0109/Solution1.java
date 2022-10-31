package leetcode.question0109;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);
        System.out.println(root.val);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode low, ListNode high) {
        if (low == high) {
            return null;
        }
        ListNode mid = getMedian(low, high);
        TreeNode left = buildBST(low, mid);
        TreeNode root = new TreeNode(mid.val);
        TreeNode right = buildBST(mid.next, high);
        root.left = left;
        root.right = right;

        return root;
    }

    private ListNode getMedian(ListNode low, ListNode high) {
        ListNode slow = low;
        ListNode fast = low;
        while (fast != high && fast.next != high) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
