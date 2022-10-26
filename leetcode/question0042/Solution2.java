package leetcode.question0042;

import org.junit.jupiter.api.Test;

public class Solution2 {

    @Test
    void test() {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0;
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;
        while (left < right) {
            leftMaxHeight = Math.max(leftMaxHeight, height[left]);
            rightMaxHeight = Math.max(rightMaxHeight, height[right]);

            if (leftMaxHeight > rightMaxHeight) {
                res += rightMaxHeight - height[right--];
            } else {
                res += leftMaxHeight - height[left++];
            }
        }

        return res;
    }
}
