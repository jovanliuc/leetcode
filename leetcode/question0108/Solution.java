package leetcode.question0108;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        sortedArrayToBST(null);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildAVT(nums, 0, nums.length - 1);
    }

    private TreeNode buildAVT(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode left = buildAVT(nums, low, mid - 1);
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode right = buildAVT(nums, mid + 1, high);
        root.left = left;
        root.right = right;

        return root;
    }
}
