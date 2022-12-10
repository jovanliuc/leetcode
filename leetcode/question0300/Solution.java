package leetcode.question0300;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    @Test
    void test() {
        lengthOfLIS(new int[] {0});
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
