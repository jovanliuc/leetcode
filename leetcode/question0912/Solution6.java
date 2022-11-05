package leetcode.question0912;

import org.junit.jupiter.api.Test;

public class Solution6 {

    @Test
    void test() {
        int[] nums = {3, 4, 5, 2, 1};
        sortArray(nums);
    }

    public int[] sortArray(int[] nums) {
        return bubbleSort(nums);
    }

    private int[] bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            boolean isSwap = false;
            for (int j = len - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    nums[j - 1] = nums[j - 1] ^ nums[j];
                    nums[j] = nums[j - 1] ^ nums[j];
                    nums[j - 1] = nums[j - 1] ^ nums[j];
                    isSwap = true;
                }
            }
            if (!isSwap) {
                return nums;
            }
        }

        return nums;
    }
}
