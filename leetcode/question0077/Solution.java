package leetcode.question0077;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> trackList = new LinkedList<>();
    int count = -1;

    @Test
    void test() {
        combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        count = k;
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int layer) {
        if (trackList.size() == count) {
            result.add(new LinkedList<>(trackList));
        }

        for (int i = layer; i < nums.length; i++) {
            trackList.addLast(nums[i]);
            backtrack(nums, i + 1);
            trackList.removeLast();
        }
    }
}
