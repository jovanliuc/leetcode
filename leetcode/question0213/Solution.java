package leetcode.question0213;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    private int[] memo1;
    private int[] memo2;

    @Test
    void test() {
        rob(new int[]{2,3,2});
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int length = nums.length;
        memo1 = new int[length];
        memo2 = new int[length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        return Math.max(dp(nums, 0, length - 2, memo1),
                dp(nums, 1, length - 1, memo2));
    }

    private int dp(int[] nums, int start, int end, int[] memo) {
        if (start > end) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }

        int result = Math.max(dp(nums, start + 1, end, memo),
                nums[start] + dp(nums, start + 2, end, memo));
        memo[start] = result;

        return result;
    }
}
