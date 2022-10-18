package leetcode.question0018;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    @Test
    void test() {
        fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        if (n < 2 || length < n) {
            return result;
        }

        if (n == 2) {
            int low = start;
            int high = length - 1;
            while (low < high) {
                int left = nums[low];
                int right = nums[high];
                int sum = left + right;
                if (sum < target) {
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                } else if (sum > target) {
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                } else if (sum == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[low], nums[high])));
                    while (low < high && nums[low] == left) {
                        low++;
                    }
                    while (low < high && nums[high] == right) {
                        high--;
                    }
                }
            }
        } else {
            int i = start;
            while (i < length) {
                int curVal = nums[i];
                List<List<Integer>> subResult = nSum(nums, n - 1, i + 1, target - curVal);
                if (subResult != null && subResult.size() > 0) {
                    for (List<Integer> list : subResult) {
                        list.add(curVal);
                        result.add(list);
                    }
                }
                while (i < length && nums[i] == curVal) {
                    i++;
                }
            }
        }

        return result;
    }
}
