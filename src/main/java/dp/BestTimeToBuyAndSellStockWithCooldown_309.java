package dp;

/**
 * @author zengjia
 * @date 2021-08-28 20:42:23
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0:持有股票，1:冷冻期未持有股票，2:非冷冻期未持有股票
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }

        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }

    /**
     * 空间优化
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int hold = -prices[0], freezingNotHold = 0, notHold = 0;

        for (int i = 1; i < len; i++) {
            int t1 = hold, t2 = freezingNotHold;
            hold = Math.max(hold, notHold - prices[i]);
            freezingNotHold = t1 + prices[i];
            notHold = Math.max(notHold, t2);
        }

        return Math.max(freezingNotHold, notHold);
    }
}
