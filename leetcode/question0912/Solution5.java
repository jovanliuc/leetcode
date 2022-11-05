package leetcode.question0912;

import org.junit.jupiter.api.Test;

public class Solution5 {

    @Test
    void test() {
        int[] nums = {5,2,3,1};
        sortArray(nums);
    }

    public int[] sortArray(int[] nums) {
        return shellSort(nums);
    }

    private int[] shellSort(int[] nums) {
        int len = nums.length;
        for (int d = len / 2; d > 0; d /= 2) {
            for (int i = d; i < len; i++) {
                int curVal = nums[i];
                int j = i - d;
                while (j >= 0 && nums[j] > curVal) {
                    nums[j + d] = nums[j];
                    j -= d;
                }
                nums[j + d] = curVal;
            }
        }

        return nums;
    }
}
