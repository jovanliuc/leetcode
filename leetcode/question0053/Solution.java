package leetcode.question0053;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int window = 0;
        while (right < nums.length) {
            window += nums[right++];
            maxSum = window > maxSum ? window : maxSum;
            while (window < 0) {
                window -= nums[left++];
            }
        }

        return maxSum;
    }
}
