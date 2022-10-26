package leetcode.question0042;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        trap(null);
    }

    public int trap(int[] height) {
        int len = height.length;
        int res = 0;

        for (int i = 0; i < len - 1; i++) {
            int leftMaxHeight = 0;
            int rightMaxHeight = 0;
            for (int j = i; j >= 0; j--) {
                leftMaxHeight = Math.max(height[j], leftMaxHeight);
            }
            for (int j = i; j < len; j++) {
                rightMaxHeight = Math.max(height[j], rightMaxHeight);
            }
            res += Math.min(leftMaxHeight, rightMaxHeight) - height[i];
        }

        return res;
    }
}
