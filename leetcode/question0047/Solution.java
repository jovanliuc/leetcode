package leetcode.question0047;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private LinkedList<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> trackList = new LinkedList<>();
    private boolean[] used;

    @Test
    void test() {
        permuteUnique(new int[]{1,1,2});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }

        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        if (trackList.size() == nums.length) {
            result.add(new LinkedList<>(trackList));
            return;
        }

        for (int i = 0; i < nums.length; i++ ) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            trackList.addLast(nums[i]);
            used[i] = true;
            backtrack(nums);
            trackList.removeLast();
            used[i] = false;
        }
    }
}
