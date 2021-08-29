package dp;

/**
 * @author zengjia
 * @date 2021-08-26 21:32:37
 */
public class MaximumProductSubarray_152 {
    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        // 自己写的
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int product = nums[i];
//            res = Math.max(res, product);
//            for (int j = i + 1; j < nums.length; j++) {
//                product *= nums[j];
//                res = Math.max(res, product);
//            }
//        }

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 0; i < length; i++) {
            int product = 1;
            for (int j = i; j < length; j++) {
                product *= nums[j];
                res = Math.max(res, product);
            }
        }
        return res;
    }

    /**
     * 递归
     *
     * @param nums
     * @return
     */
    int res = Integer.MIN_VALUE;

    public int maxProduct1(int[] nums) {
        dfs(nums, 0, nums[0]);
        return res;
    }

    private void dfs(int[] nums, int i, int product) {
        res = Math.max(res, product);
        if (i == nums.length - 1) {
            return;
        }

        dfs(nums, i + 1, product * nums[i]);
        dfs(nums, i + 1, nums[i]);
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
        }
        int res = dp[0][0];
        for (int i = 1; i < length; i++) {
            res = Math.max(dp[i][0], res);
        }
        return res;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct3(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
        }
        int res = max[0];
        for (int i = 1; i < length; i++) {
            res = Math.max(max[i], res);
        }
        return res;
    }

    /**
     * 动态规划 通过滚动数组优化空间复杂度
     *
     * @param nums
     * @return
     */
    public int maxProduct4(int[] nums) {
        int length = nums.length;
        int res = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < length; i++) {
            int curMax = max;
            max = Math.max(Math.max(curMax * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(curMax * nums[i], min * nums[i]), nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
