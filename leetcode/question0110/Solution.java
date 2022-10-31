package leetcode.question0110;

import org.junit.jupiter.api.Test;

public class Solution {

    boolean isBalanced = true;

    @Test
    void test() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        isBalanced(root);
    }

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    private int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        if (Math.abs(leftMaxDepth - rightMaxDepth) > 1) {
            isBalanced = false;
        }

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
