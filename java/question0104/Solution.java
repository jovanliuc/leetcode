package java.question0104;

import org.junit.Test;

public class Solution {

    int maxDepth = 0;
    int depth = 0;

    @Test
    void test() {
        maxDepth(null);
    }

    public int maxDepth(TreeNode root) {
        maxDepth1(root);
        return maxDepth;
    }

    private void maxDepth1(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        maxDepth1(root.left);
        maxDepth = depth > maxDepth ? depth : maxDepth;
        maxDepth1(root.right);
        depth--;
    }
}
