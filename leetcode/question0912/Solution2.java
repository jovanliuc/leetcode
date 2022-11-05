package leetcode.question0912;

import org.junit.jupiter.api.Test;

public class Solution2 {

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
            int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = tmp;
        }

        return nums;
    }
}
