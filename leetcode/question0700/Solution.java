package leetcode.question0700;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(20);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(10);
        root.left.right =  new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(90);
        searchBST(root, 80);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val == root.val) {
            return root;
        }

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        
        return left != null ? left : right;
    }
}
