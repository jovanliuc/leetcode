package leetcode.question1038;

import org.junit.jupiter.api.Test;

public class Solution {

    private int sum = 0;

    @Test
    void test() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(10);
        root.left.right =  new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(90);
        bstToGst(root);
    }

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.right);
        root.val = sum += root.val;
        traverse(root.left);
    }
}
