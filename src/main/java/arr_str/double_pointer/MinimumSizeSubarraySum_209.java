package arr_str.double_pointer;

import java.util.Arrays;

/**
 * @author zengjia
 * @date 2021-04-07 11:24:23
 */
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        break;
                    }
                }
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen3(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int k = sums[i - 1] + target;
            int bound = Arrays.binarySearch(sums, k);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum_209 a = new MinimumSizeSubarraySum_209();
        a.minSubArrayLen3(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}
