package leetcode.question0106;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution {

    final HashMap<Integer, Integer> val2Index = new HashMap<>();

    @Test
    void test() {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0
                || postorder == null || postorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            val2Index.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1,
                         postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                               int[] postorder, int postStart, int postEnd) {
        // base case
        if (postStart > postEnd) {
            return null;
        }

        int rootValOfPostOrder = postorder[postEnd];
        int indexOfInorder = val2Index.get(rootValOfPostOrder);
        int leftSize = indexOfInorder - inStart;

        TreeNode root = new TreeNode(rootValOfPostOrder);
        root.left = buildTree(inorder, inStart, indexOfInorder - 1,
                              postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, indexOfInorder + 1, inEnd,
                               postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
