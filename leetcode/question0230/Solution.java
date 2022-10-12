package leetcode.question0230;

import org.junit.jupiter.api.Test;

public class Solution {

    private int kthSmallest = 0;
    private int rank = 0;

    @Test
    void test() {
        kthSmallest(null, 0);
    }

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return kthSmallest;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        rank++;
        if (k == rank) {
            kthSmallest = root.val;
        }
        traverse(root.right, k);
    }
}
