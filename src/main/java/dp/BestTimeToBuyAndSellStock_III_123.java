package dp;

/**
 * @author zengjia
 * @date 2021-08-28 21:31:03
 */
public class BestTimeToBuyAndSellStock_III_123 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }

        // 0：第一次买入，1：第一次卖出，2：第二次买入，3：第二次卖出
        int[][] dp = new int[length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        return dp[length - 1][3];
    }

    /**
     * 优化空间复杂度
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }

        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;

        for (int i = 1; i < length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        return sell2;
    }
}
