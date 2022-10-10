package leetcode.question0704;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int index = search(nums, 5);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
