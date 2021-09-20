package leetcode.editor.cn;

//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 树状数组 线段树 数组 动态规划 👍 418 👎 0


public class NumberOfLongestIncreasingSubsequence_673 {

    public static void main(String[] args) {
        Solution solution = new NumberOfLongestIncreasingSubsequence_673().new Solution();
        solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int[] count = new int[n];
            dp[0] = 1;
            count[0] = 1;
            int maxLen = 1, res = 0;
            for (int i = 1; i < n; i++) {
                dp[i] = 1;
                count[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            count[i] = count[j];
                        } else if (dp[j] + 1 == dp[i]) {
                            count[i] += count[j];
                        }
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            for (int i = 0; i < n; i++) {
                if (dp[i] == maxLen) {
                    res += count[i];
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}