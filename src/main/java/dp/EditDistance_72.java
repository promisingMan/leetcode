package dp;

/**
 * @author zengjia
 * @date 2021-08-31 19:52:46
 */
public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int i, int j) {
        if (i == word1.length() || j == word2.length()) {
            return word1.length() - i + word2.length() - j;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dfs(word1, word2, i + 1, j + 1);
        } else {
            int insert = dfs(word1, word2, i + 1, j);
            int delete = dfs(word1, word2, i, j + 1);
            int replace = dfs(word1, word2, i + 1, j + 1);
            return Math.min(Math.min(insert, delete), replace) + 1;
        }
    }

    public int minDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}