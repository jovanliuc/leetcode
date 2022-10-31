package leetcode.question0109;

import org.junit.jupiter.api.Test;

public class Solution {

    ListNode cur;

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
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        cur = head;
        return buildBST(0, len - 1);
    }

    private TreeNode buildBST(int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode left = buildBST(low, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = buildBST(mid + 1, high);
        root.left = left;
        root.right = right;

        return root;
    }
}
