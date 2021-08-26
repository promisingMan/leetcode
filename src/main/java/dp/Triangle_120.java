package dp;

import java.util.List;

/**
 * @author zengjia
 * @date 2021-08-26 08:45:46
 */
public class Triangle_120 {
    int res = Integer.MAX_VALUE;

    /**
     * 自己写的递归
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        dfs(0, 0, 0, triangle);
        return res;
    }

    private void dfs(Integer sum, int i, int j, List<List<Integer>> triangle) {
        sum += triangle.get(i).get(j);

        if (i == triangle.size() - 1) {
            res = Math.min(res, sum);
            return;
        }

        dfs(sum, i + 1, j, triangle);
        dfs(sum, i + 1, j + 1, triangle);
    }

    /**
     * 递归深搜
     *
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 记忆化递归深搜
     *
     * @param triangle
     * @return
     */
    Integer[][] memo;

    public int minimumTotal2(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs1(triangle, 0, 0);
    }

    private int dfs1(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs1(triangle, i + 1, j), dfs1(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * 动态规划
     *
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 动态规划空间优化
     *
     * @param triangle
     * @return
     */
    public int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
