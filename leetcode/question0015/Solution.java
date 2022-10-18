package leetcode.question0015;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    @Test
    void test() {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = nSum(nums, 3, 0, 0);
        return result;
    }

    private List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();

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
                    while(low < high && nums[high] == right) {
                        high--;
                    }
                }
            }
        } else {
            int i = start;
            while (i < length) {
                int curVal = nums[i];
                List<List<Integer>> subResult = nSum(nums, n - 1, i + 1, target - curVal);
                for (List<Integer> list : subResult) {
                    list.add(curVal);
                    result.add(list);
                }
                while (i < length && nums[i] == curVal) {
                    i++;
                }
            }
        }

        return result;
    }
}











