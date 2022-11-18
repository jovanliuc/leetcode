package leetcode.question0496;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    @Test
    void test() {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " -> ");
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums = nextGreaterElement(nums2);
        HashMap<Integer, Integer> nextGreaterEleMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nextGreaterEleMap.put(nums2[i], nums[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreaterEleMap.get(nums1[i]);
        }

        return res;
    }

    private int[] nextGreaterElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >=0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return res;
    }
}
