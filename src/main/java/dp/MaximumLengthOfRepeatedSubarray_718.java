package dp;

/**
 * 题解：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zhe-yao-jie-shi-ken-ding-jiu-dong-liao-by-hyj8/
 * @author zengjia
 * @date 2021-09-01 14:37:19
 */
public class MaximumLengthOfRepeatedSubarray_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        int res = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }
}
