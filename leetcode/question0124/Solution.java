package leetcode.question0124;

import org.junit.jupiter.api.Test;

public class Solution {

    private int result = Integer.MIN_VALUE;

    @Test
    void test() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        maxPathSum(root);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathSum0(root);
        return result;
    }

    private int maxPathSum0(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftMaxPathSum = Math.max(maxPathSum0(root.left), 0);
        int rightMaxPathSum = Math.max(maxPathSum0(root.right), 0);
        int maxPathSum = leftMaxPathSum + rightMaxPathSum + root.val;
        result = Math.max(maxPathSum, result);

        return Math.max(leftMaxPathSum, rightMaxPathSum) + root.val;
    }
}
