package leetcode.question0090;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> trackList = new LinkedList<>();

    @Test
    void test() {
        subsetsWithDup(new int[]{1, 2, 2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int layer) {
        result.add(new LinkedList<>(trackList));

        for (int i = layer; i < nums.length; i++) {
            if ( i > layer && nums[i] == nums[i - 1]) {
                continue;
            }
            trackList.addLast(nums[i]);
            backtrack(nums, i + 1);
            trackList.removeLast();
        }
    }
}
