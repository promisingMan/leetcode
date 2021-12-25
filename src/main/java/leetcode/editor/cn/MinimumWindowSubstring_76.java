package leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1397 👎 0


public class MinimumWindowSubstring_76 {

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring_76().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || t.length() == 0) {
                return "";
            }
            // 记录需要的字符的个数
            int[] need = new int[128];
            int needCount = t.length();
            for (int i = 0; i < needCount; i++) {
                need[t.charAt(i)]++;
            }

            int l = 0, r = 0, size = Integer.MAX_VALUE, start = 0;
            while (r < s.length()) {
                char c = s.charAt(r);
                // 表示t中包含当前遍历到的这个c字符，更新目前所需要的needCount数大小
                if (need[c] > 0) {
                    needCount--;
                }
                // 无论这个字符是否包含在t中，need[]数组中对应那个字符的计数都减少1，利用正负区分这个字符是多余的还是有用的
                need[c]--;

                // needCount == 0 说明当前的窗口已经满足了包含t所需所有字符的条件
                if (needCount == 0) {
                    // 如果左边界这个字符对应的值在need[]数组中小于0，说明他是一个多余元素，不包含在t内
                    while (l < r && need[s.charAt(l)] < 0) {
                        need[s.charAt(l)]++;
                        l++;
                    }

                    // 符合条件的子串长度
                    int len = r - l + 1;
                    // 更新最小子串长度与开始位置
                    if (len < size) {
                        size = len;
                        start = l;
                    }

                    // 先将l位置的字符计数加1
                    need[s.charAt(l)]++;
                    // 重新维护左边界值和当前所需字符的值 needCount
                    l++;
                    needCount++;
                }
                // 右移边界，开始下一次循环
                r++;
            }
            return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}