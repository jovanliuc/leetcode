package leetcode.question0035;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        searchInsert(new int[]{1,3,5,6}, 5);
    }

    public int searchInsert(int[] nums, int target) {
        return searchLeftBound(nums, target);
    }

    private int searchLeftBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            } else if (target == nums[mid]) {
                right = mid;
            }
        }

        return left;
    }
}
