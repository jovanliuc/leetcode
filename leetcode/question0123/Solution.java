package leetcode.question0123;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        maxProfit(new int[]{7,1,5,3,6,4});
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxK = 2;
        int n = prices.length;
        int[][][] dp = new int[n][maxK + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][maxK][0];
    }
}
