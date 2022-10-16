package leetcode.question0040;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private LinkedList<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> trackList = new LinkedList<>();
    int sum = 0;

    @Test
    void test() {
        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int layer) {
        // base case
        if (sum == target) {
            result.add(new LinkedList<>(trackList));
            return;
        }

        // base case
        if (sum > target) {
            return;
        }

        for (int i = layer; i < candidates.length; i++) {
            if (i > layer && candidates[i] == candidates[i - 1]) {
                continue;
            }

            trackList.addLast(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i + 1);
            trackList.removeLast();
            sum -= candidates[i];
        }
    }
}
