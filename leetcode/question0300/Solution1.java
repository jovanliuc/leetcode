package leetcode.question0300;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        lengthOfLIS(new int[] {0});
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] top = new int[len];
        int piles = 0;
        for (int i = 0; i < len; i++) {
            int poker = nums[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) piles++;
            top[left] = poker;
        }

        return piles;
    }
}
