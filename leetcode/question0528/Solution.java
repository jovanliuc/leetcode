package leetcode.question0528;

import java.util.Random;

public class Solution {

    private int[] preSum;
    private Random random = new Random();

    public Solution(int[] w) {
        int length = w.length;
        preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= length; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int target = random.nextInt(preSum[preSum.length - 1]) + 1;
            return searchLeftBound(preSum, target) - 1;
    }

    private int searchLeftBound(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        return left;
    }
}
