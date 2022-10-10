package leetcode.question0034;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[] nums = {5,6,6,7,7,8,8,8,10};
        int target = 6;
        searchRange(nums, target);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }

        result[0] = searchLeftBound(nums, target);
        result[1] = searchRightBound(nums, target);

        return result;
    }

    private int searchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                right = mid;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        } else {
            return left;
        }
    }

    private int searchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right - 1 < 0 || nums[right - 1] != target) {
            return -1;
        } else {
            return right - 1;
        }
    }
}
