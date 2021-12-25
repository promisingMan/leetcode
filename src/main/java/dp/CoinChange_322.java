package dp;

/**
 * @author zengjia
 * @date 2021-08-30 21:05:26
 */
public class CoinChange_322 {
    /**
     * 递归
     *
     * @param coins
     * @param amount
     * @return
     */
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return res;
    }

    public void dfs(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int coin : coins) {
            dfs(coins, amount - coin, count + 1);
        }
    }

    /**
     * 记忆化搜索
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        int[] memo = new int[amount];
        return memoSearch(coins, amount, memo);
    }

    public int memoSearch(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = memoSearch(coins, amount - coin, memo);
            if (0 <= res && res < min) {
                min = res + 1;
            }
        }

        memo[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[amount - 1];
    }

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
