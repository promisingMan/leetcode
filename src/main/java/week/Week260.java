package week;

/**
 * @author zengjia
 * @date 2021-09-26 09:34:16
 */
public class Week260 {
    public static void main(String[] args) {
        Week260 w = new Week260();
        w.gridGame(new int[][]{{2,5,4}, {1,5,1}});
    }

    public int maximumDifference(int[] nums) {
        int max = -1;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, nums[j] - nums[i]);
                }
            }
        }
        return max;
    }

    public long gridGame(int[][] grid) {
        long i = maxValue(grid);
        return i;
    }

    public long maxValue(int[][] grid) {
        int n = grid[0].length;
        long[][] dp = new long[2][n];
        dp[0][0] = grid[0][0];
        dp[1][0] = grid[0][0] + grid[1][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] += dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < 2; i++) {
            for (int j = 1; j < n; j++) {
                long max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = max + grid[i][j];
            }
        }
        int i = 1, j = n - 1;
        long sum = 0;
        long a = n - 1;
        while (a > 0) {
            if (i == 0) {
                j = j - 1;
                sum += grid[1][j - 1];
                a--;
                continue;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    sum += grid[1][j - 1];
                    i = 0;
                    j = j;
                } else {
                    sum += grid[0][j];
                    i = 1;
                    j = j - 1;
                }
                a--;
            }
        }
        return sum;
    }
}
