package leetcode.question0889;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution {

    final HashMap<Integer, Integer> val2Index = new HashMap<>();

    @Test
    void test() {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        constructFromPrePost(preorder, postorder);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || preorder.length == 0
                || postorder == null || postorder.length == 0) {
            return null;
        }

        for (int i = 0; i < postorder.length; i++) {
            val2Index.put(postorder[i], i);
        }

        return constructFromPrePost(preorder, 0, preorder.length - 1,
                             postorder, 0, postorder.length - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preStart, int preEnd,
                                          int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootValOfPreorder = preorder[preStart];
        int leftRootValOfPreorder = preorder[preStart + 1];
        int indexOfLeftRootVal = val2Index.get(leftRootValOfPreorder);
        int leftSize = indexOfLeftRootVal - postStart + 1;

        TreeNode root = new TreeNode(rootValOfPreorder);
        root.left = constructFromPrePost(preorder, preStart + 1, preStart + leftSize,
                                         postorder, postStart, indexOfLeftRootVal);
        root.right = constructFromPrePost(preorder, preStart + leftSize + 1, preEnd,
                                          postorder, indexOfLeftRootVal + 1, postEnd - 1);

        return root;
    }
}
