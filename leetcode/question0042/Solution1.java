package leetcode.question0042;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        trap(null);
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0;
        int len = height.length;
        int[] leftMaxHeightMemo = new int[len];
        int[] rightMaxHeightMemo = new int[len];
        leftMaxHeightMemo[0] = height[0];
        rightMaxHeightMemo[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            leftMaxHeightMemo[i] = Math.max(height[i], leftMaxHeightMemo[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMaxHeightMemo[i] = Math.max(height[i], rightMaxHeightMemo[i + 1]);
        }
        for (int i = 1; i <= len - 1; i++) {
            res += Math.min(leftMaxHeightMemo[i], rightMaxHeightMemo[i]) - height[i];
        }

        return res;
    }
}
