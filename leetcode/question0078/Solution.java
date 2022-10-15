package leetcode.question0078;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> trackList = new LinkedList<>();

    @Test
    void test() {
        subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int layer) {
        result.add(new LinkedList<>(trackList));
        for (int i = layer; i < nums.length; i++) {
            trackList.addLast(nums[i]);
            backtrack(nums, i + 1);
            trackList.removeLast();
        }
    }
}
