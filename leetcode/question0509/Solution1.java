package leetcode.question0509;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        int sum = fib(10);
        System.out.println(sum);
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
