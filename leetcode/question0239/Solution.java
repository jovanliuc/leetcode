package leetcode.question0239;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        MonotonicQueue<Integer> slidingWindow = new MonotonicQueue<>();
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                slidingWindow.push(nums[i]);
            } else {
                slidingWindow.push(nums[i]);
                res[i - k + 1] = slidingWindow.max();
                slidingWindow.pop();
            }
        }

        return res;
    }
}
