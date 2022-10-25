package leetcode.question0912;

import org.junit.jupiter.api.Test;

public class Solution1 {

    private int[] temp;

    @Test
    void test() {
        sortArray(null);
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int len = nums.length;
        temp = new int[len];
        mergeSort(nums, 0, len - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i ++) {
            temp[i] = nums[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        while (j <= high) {
            nums[k++] = temp[j++];
        }
    }
}
