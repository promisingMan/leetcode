package leetcode.editor.cn;

//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 180 👎 0


import java.util.List;

public class 通过删除字母匹配到字典里最长单词_524 {
    public static void main(String[] args) {
        new 通过删除字母匹配到字典里最长单词_524().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String res = "";
            int len = s.length();
            for (String dict : dictionary) {
                int i = 0, j = 0;
                int dictLen = dict.length();
                if (len < dictLen) {
                    continue;
                }
                while (i < len && j < dictLen) {
                    if (s.charAt(i) == dict.charAt(j)) {
                        j++;
                    }
                    i++;
                }
                if (j == dictLen) {
                    if (dictLen == res.length()) {
                        res = dict.compareTo(res) < 0 ? dict : res;
                    }
                    if (dictLen > res.length()) {
                        res = dict;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
