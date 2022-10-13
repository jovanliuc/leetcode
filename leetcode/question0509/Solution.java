package leetcode.question0509;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int sum = fib(10);
        System.out.println(sum);
    }

    public int fib(int n) {
        int[] memo = new int[n + 1];
        return fib(n, memo);
    }

    private int fib(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }
}
