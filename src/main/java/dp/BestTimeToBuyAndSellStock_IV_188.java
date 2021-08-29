package dp;

/**
 * @author zengjia
 * @date 2021-08-27 21:31:03
 */
public class BestTimeToBuyAndSellStock_IV_188 {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (k == 0 || length == 0) {
            return 0;
        }

        int[][][] dp = new int[length][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j][0] = dp[i - 1][j][0];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                }
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, dp[length - 1][i][0]);
        }
        return res;
    }
}
