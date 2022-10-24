package leetcode.question0215;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class Solution1 {

    @Test
    void test() {
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void shuffle(int[]  nums) {
        int len = nums.length;
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            int j = r.nextInt(len);
            if (i == j) {
                continue;
            }
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int pivotVal = nums[low];
        while(low < high) {
            while (low < high && nums[high] >= pivotVal) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivotVal) {
                low++;
            }
            nums[high] = nums[low];
        }

        nums[low] = pivotVal;
        return low;
    }
}
