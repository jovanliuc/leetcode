package leetcode.question0912;

import org.junit.jupiter.api.Test;

public class Solution3 {

    @Test
    void test() {
        int[] nums = {5,2,3,1};
        sortArray(nums);
    }

    public int[] sortArray(int[] nums) {
        int[] numsWithSentinel = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            numsWithSentinel[i + 1] = nums[i];
        }
        numsWithSentinel = insertSortWithSentinel(numsWithSentinel);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsWithSentinel[i + 1];
        }
        return nums;
    }

    private int[] insertSortWithSentinel(int[] nums) {
        int len = nums.length;
        for (int i = 2; i < len; i++) {
            nums[0] = nums[i];
            int j = i - 1;
            while (nums[j] > nums[0]) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = nums[0];
        }

        return nums;
    }
}
