package leetcode.question0322;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution1 {

    @Test
    void test() {
        int[] coins = {2};
        int amount = 3;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        // base case
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = dp[i] > dp[i - coin] + 1 ? dp[i - coin] + 1 : dp[i];
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
