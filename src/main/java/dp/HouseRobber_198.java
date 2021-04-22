package dp;

/**
 * @author zengjia
 * @date 2021-04-19 21:16:20
 */
public class HouseRobber_198 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[length - 1];
    }

    /**
     * 滚动数组，优化空间复杂度
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp;
        for (int i = 2; i < nums.length; i++) {
            temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }

        return second;
    }
}
