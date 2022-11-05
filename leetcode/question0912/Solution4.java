package leetcode.question0912;

import org.junit.jupiter.api.Test;

public class Solution4 {

    @Test
    void test() {
        int[] nums = {5,2,3,1};
        sortArray(nums);
    }

    public int[] sortArray(int[] nums) {
        return insertSort(nums);
    }

    private int[] insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int curVal = nums[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] > curVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            int j = i - 1;
            while (j >= low) {
                nums[j + 1] = nums[j--];
            }
            nums[low] = curVal;
        }

        return nums;
    }
}
