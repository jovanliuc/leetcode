package leetcode.question1382;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        balanceBST(root);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorderList = inorder(root);
        return buildAVL(inorderList, 0, inorderList.size() - 1);
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // base case
        if (root == null) {
            return res;
        }
        res.addAll(inorder(root.left));
        res.add(root.val);
        res.addAll(inorder(root.right));

        return res;
    }

    private TreeNode buildAVL(List<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildAVL(list, low, mid - 1);
        root.right = buildAVL(list, mid + 1, high);
        return root;
    }
}
