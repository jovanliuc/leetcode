package leetcode.question0022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    @Test
    void test() {
        generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        List<String> res = new ArrayList<>();
        Stack<String> track = new Stack<>();
        backtrack(res, track, n, n);
        return res;
    }

    private void backtrack(List<String> res, Stack<String> track, int leftCount, int rightCount) {
        if (leftCount < 0 || rightCount < 0 || rightCount < leftCount) {
            return;
        }
        if (leftCount == 0 && rightCount == 0) {
            res.add(track.stream().reduce("", String::concat));
            return;
        }

        track.push("(");
        backtrack(res, track, leftCount - 1, rightCount);
        track.pop();

        track.push(")");
        backtrack(res, track, leftCount, rightCount - 1);
        track.pop();
    }
}
