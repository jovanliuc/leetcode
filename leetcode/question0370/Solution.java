package leetcode.question0370;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        getModifiedArray(9, null);
    }

    private int[] nums;
    private int[] diff;

    public int[] getModifiedArray(int length, int[][] updates) {
        if (length == 0) {
            return nums;
        }

        diff(length);

        for (int[] update : updates) {
            int left = update[0];
            int right = update[1];
            int val = update[2];

            increment(left, right, val);
        }

        result();
        return nums;
    }

    private void diff(int length) {
        nums = new int[length];
        diff = new int[length];
        diff[0] = nums[0];
        for (int i = 1; i < length; i++) {
            diff[i] = nums[i] - nums[i - 0];
        }
    }

    private void increment(int left, int right, int val) {
        diff[left] += val;
        if (right + 1 < nums.length) {
            diff[right + 1] -= val;
        }
    }

    private void result() {
        nums[0] = diff[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }
    }
}
