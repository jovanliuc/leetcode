package leetcode.question0450;

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

        deleteNode(root, 20);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // base case
        if (root == null) {
            return null;
        }

        if (key == root.val) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minSuccessorOfRightSubsTree = getMinSuccessorOfRightSubsTree(root.right);
                root.right = deleteNode(root.right, minSuccessorOfRightSubsTree.val);
                minSuccessorOfRightSubsTree.left = root.left;
                minSuccessorOfRightSubsTree.right = root.right;
                root = minSuccessorOfRightSubsTree;
            }
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMinSuccessorOfRightSubsTree(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
