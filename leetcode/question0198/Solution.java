package leetcode.question0198;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    private int[] memo;

    @Test
    void test() {
        rob(new int[]{1,2,3,1});
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }

        int result = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        memo[start] = result;

        return result;
    }
}
