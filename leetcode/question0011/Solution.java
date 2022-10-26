package leetcode.question0011;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        maxArea(null);
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int maxArea = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(maxArea, res);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
