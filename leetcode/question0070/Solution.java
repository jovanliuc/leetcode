package leetcode.question0070;

import org.junit.jupiter.api.Test;

public class Solution {

    private int[] memo;

    @Test
    void test() {
        int result = climbStairs(6);
        System.out.println(result);
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        memo = new int[n + 1];
        return dp(n);
    }

    private int dp(int n) {
        // base case
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }
}
