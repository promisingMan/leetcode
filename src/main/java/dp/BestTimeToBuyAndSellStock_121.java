package dp;

/**
 * @author zengjia
 * @date 2021-08-09 21:31:03
 */
public class BestTimeToBuyAndSellStock_121 {
    /**
     * 暴力解法
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int maxprofit = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                maxprofit = Math.max(maxprofit, prices[j] - prices[i]);
            }
        }
        return maxprofit;
    }

    /**
     * 动态规划
     * dp[i] 表示前i天的最大利润，因为我们始终要使利润最大化，则：
     * dp[i] = max(dp[i-1], prices[i]-minprice)
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        int[] dp = new int[length];
        int minprice = prices[0];
        for (int i = 1; i < length; i++) {
            minprice = Math.min(minprice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minprice);
        }
        return dp[length - 1];
    }

    /**
     * 动态规划 优化空间复杂度
     * dp[i] 表示前i天的最大利润，因为我们始终要使利润最大化，则：
     * dp[i] = max(dp[i-1], prices[i]-minprice)
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        int minprice = prices[0];
        int maxprofit = 0;
        for (int i = 1; i < length; i++) {
            minprice = Math.min(minprice, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }
        return maxprofit;
    }
}
