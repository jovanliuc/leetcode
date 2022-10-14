package leetcode.question0046;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    @Test
    void test() {
        permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trackList = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, trackList, used);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> trackList, boolean[] used) {
        if (trackList.size() == nums.length) {
            result.add(new ArrayList<>(trackList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            trackList.add(nums[i]);
            used[i] = true;
            backtrack(nums, trackList, used);
            trackList.removeLast();
            used[i] = false;
        }
    }
}
