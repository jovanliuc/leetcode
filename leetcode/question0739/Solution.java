package leetcode.question0739;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution {

    @Test
    void test() {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return res;
    }
}
