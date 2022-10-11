package leetcode.question0870;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    @Test
    void test() {
        int[] nums1 = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        advantageCount(nums1, nums2);
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }

        int length = nums1.length;
        PriorityQueue<int[]> maxPriorityQueue = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> pair2[1] - pair1[1]
        );
        for (int i = 0; i < length; i++) {
            maxPriorityQueue.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);

        int[] result = new int[length];
        int left = 0;
        int right = length - 1;
        while (!maxPriorityQueue.isEmpty()) {

            int[] pair = maxPriorityQueue.poll();
            int index = pair[0];
            int maxVal = pair[1];
            if(nums1[right] > maxVal) {
                result[index] = nums1[right];
                right--;
            } else {
                result[index] = nums1[left];
                left++;
            }
        }

        return result;
    }
}
