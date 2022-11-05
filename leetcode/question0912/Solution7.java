package leetcode.question0912;

import org.junit.jupiter.api.Test;

public class Solution7 {

    @Test
    void test() {
        int[] nums = {3, 4, 5, 2, 1};
        sortArray(nums);
    }

    public int[] sortArray(int[] nums) {
        return selectSort(nums);
    }

    private int[] selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                nums[i] = nums[min] ^ nums[i];
                nums[min] = nums[min] ^ nums[i];
                nums[i] = nums[min] ^ nums[i];
            }
        }
        return nums;
    }
}
