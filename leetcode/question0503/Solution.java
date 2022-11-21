package leetcode.question0503;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution {

    @Test
    void test() {
        int[] nums = {1,2,3,4,3};
        nextGreaterElements(nums);
    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % len] >= stack.peek()) {
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }

        return res;
    }
}
