package leetcode.question0509;

import org.junit.jupiter.api.Test;

public class Solution2 {

    @Test
    void test() {
        int sum = fib(10);
        System.out.println(sum);
    }

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}
