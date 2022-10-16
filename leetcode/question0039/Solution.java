package leetcode.question0039;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    private LinkedList<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> trackList = new LinkedList<>();
    private int sum = 0;

    @Test
    void test() {
        combinationSum(new int[]{2,3,6,7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }

        if (candidates.length == 0) {
            return result;
        }

        backtrack(candidates, target, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, int layer) {
        if (sum == target) {
            result.add(new LinkedList<>(trackList));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = layer; i < candidates.length; i++ ) {
            trackList.addLast(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i);
            trackList.removeLast();
            sum -= candidates[i];
        }
    }
}
