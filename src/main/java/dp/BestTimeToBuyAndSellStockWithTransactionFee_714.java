package dp;

/**
 * @author zengjia
 * @date 2021-08-28 20:20:53
 */
public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    /**
     * 动态规划
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len - 1][0];
    }

    /**
     * 动态规划，优化空间复杂度
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit1(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int notHold = 0, hold = -prices[0];

        for (int i = 1; i < len; i++) {
            int temp = notHold;
            notHold = Math.max(notHold, hold + prices[i] - fee);
            hold = Math.max(hold, temp - prices[i]);
        }

        return notHold;
    }

    /**
     * 贪心
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int buy = prices[0] + fee;
        int maxProfit = 0;

        for (int price : prices) {
            if (price + fee < buy) {
                buy = price + fee;
            } else if (price > buy){
                maxProfit += price - buy;
                buy = price;
            }
        }

        return maxProfit;
    }
}
