package leetcode.question0001;



import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Solution {

    @Test
    void test() {
        twoSum(null, 0);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{valToIndex.get(need), i};
            }
            valToIndex.put(nums[i], i);
        }
        return null;
    }
}
