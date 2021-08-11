package dp;

/**
 * @author zengjia
 * @date 2021-08-09 21:31:03
 */
public class BestTimeToBuyAndSellStock_II_122 {
    /**
     * 动态规划
     * dp[i][0/1]：第i天是否持有股票时的现金数
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int[][] dp = new int[length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    /**
     * 动态规划，解法1中可以看出第i天的现金数只跟前一天是否持有股票相关
     * 所以只需要用两个变量保存前一天的结果即可
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        int preNotHold = 0;
        int preHold = -prices[0];

        for (int i = 1; i < length; i++) {
            preNotHold = Math.max(preNotHold, preHold + prices[i]);
            preHold = Math.max(preHold, preNotHold - prices[i]);
        }
        return preNotHold;
    }

    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        int maxprofit = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
