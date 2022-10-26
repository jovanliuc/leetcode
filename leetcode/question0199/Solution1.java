package leetcode.question0199;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    private LinkedList<Integer> res;
    private int depth;

    @Test
    void test() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        rightSideView(root);
    }

    public List<Integer> rightSideView(TreeNode root) {
        this.res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        depth = 0;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        if (res.size() < depth) {
            res.add(root.val);
        }
        traverse(root.right);
        traverse(root.left);
        depth--;
    }
}
