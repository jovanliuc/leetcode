package leetcode.question0105;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution {

    final HashMap<Integer, Integer> val2Index = new HashMap<>();

    @Test
    void test() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            val2Index.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1,
                         inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int rootValOfPreorder = preorder[preStart];
        int index = val2Index.get(rootValOfPreorder);
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootValOfPreorder);
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize,
                              inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd,
                               inorder, index + 1, inEnd);
        return root;
    }
}
