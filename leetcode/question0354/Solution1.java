package leetcode.question0354;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution1 {

    @Test
    void test() {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        maxEnvelopes(envelopes);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        int len = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] height = new int[len];
        for (int i = 0; i < len; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = i -1; j >=0; j--) {
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
