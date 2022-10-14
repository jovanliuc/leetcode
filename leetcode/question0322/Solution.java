package leetcode.question0322;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    private int[] memo;

    @Test
    void test() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        memo[0] = 0;
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        // base case
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != -2) {
            return memo[amount];
        }

        int result = Integer.MAX_VALUE;
        for (int coin: coins) {
            int subResult = dp(coins, amount - coin);
            if (subResult == -1) {
                continue;
            }
            result = result > subResult + 1 ? subResult + 1 : result;
        }

        return memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
    }
}
