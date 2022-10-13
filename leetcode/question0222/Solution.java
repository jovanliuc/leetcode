package leetcode.question0222;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);
        root.left.right =  new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(90);

        countNodes(root);
    }

    public int countNodes(TreeNode root) {
        TreeNode leftCurrent = root;
        TreeNode rightCurrent = root;
        int leftHeight = 0;
        int rightHeight = 0;

        while (leftCurrent != null) {
            leftCurrent = leftCurrent.left;
            leftHeight++;
        }

        while (rightCurrent != null) {
            rightCurrent = rightCurrent.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
