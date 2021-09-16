package leetcode.editor.cn;

//给你一个字符串 s ，请你找到 s 中两个 不相交回文子序列 ，使得它们长度的 乘积最大 。两个子序列在原字符串中如果没有任何相同下标的字符，则它们是 不相
//交 的。 
//
// 请你返回两个回文子序列长度可以达到的 最大乘积 。 
//
// 子序列 指的是从原字符串中删除若干个字符（可以一个也不删除）后，剩余字符不改变顺序而得到的结果。如果一个字符串从前往后读和从后往前读一模一样，那么这个字符
//串是一个 回文字符串 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：s = "leetcodecom"
//输出：9
//解释：最优方案是选择 "ete" 作为第一个子序列，"cdc" 作为第二个子序列。
//它们的乘积为 3 * 3 = 9 。
// 
//
// 示例 2： 
//
// 输入：s = "bb"
//输出：1
//解释：最优方案为选择 "b" （第一个字符）作为第一个子序列，"b" （第二个字符）作为第二个子序列。
//它们的乘积为 1 * 1 = 1 。
// 
//
// 示例 3： 
//
// 输入：s = "accbcaxxcxx"
//输出：25
//解释：最优方案为选择 "accca" 作为第一个子序列，"xxcxx" 作为第二个子序列。
//它们的乘积为 5 * 5 = 25 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 12 
// s 只含有小写英文字母。 
// 
// Related Topics 位运算 字符串 动态规划 回溯 状态压缩 👍 10 👎 0


public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences_2002 {

    public static void main(String[] args) {
        Solution solution = new MaximumProductOfTheLengthOfTwoPalindromicSubsequences_2002().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 1;

        public int maxProduct(String s) {
            dfs(s, "", "", 0);
            return res;
        }

        private void dfs(String s, String s1, String s2, int i) {
            if (check(s1) && check(s2)) {
                res = Math.max(res, s1.length() * s2.length());
            }

            if (i == s.length()) {
                return;
            }

            dfs(s, s1 + s.charAt(i), s2, i + 1);
            dfs(s, s1, s2 + s.charAt(i), i + 1);
            dfs(s, s1, s2, i + 1);
        }

        private boolean check(String s) {
            int l = 0, r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}