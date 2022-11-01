package leetcode.question0004;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1 + len2];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j <len2) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < len1) {
            nums[k++] = nums1[i++];
        }
        while (j < len2) {
            nums[k++] = nums2[j++];
        }

        if (k % 2 == 0) {
            return (double) (nums[k / 2 - 1] + nums[k / 2]) / 2;
        } else {
            return nums[k / 2];
        }
    }
}
