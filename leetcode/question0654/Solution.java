package leetcode.question0654;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
        // base case
        if (low > high) {
            return null;
        }

        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if (maxVal < nums[i]) {
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = constructMaximumBinaryTree(nums, low, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, high);

        return root;
    }
}
