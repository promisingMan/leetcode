package dp;

import java.util.Arrays;

/**
 * @author zengjia
 * @date 2021-03-14 18:41:27
 */
public class 最长递增子序列_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        return 1;
    }
}
