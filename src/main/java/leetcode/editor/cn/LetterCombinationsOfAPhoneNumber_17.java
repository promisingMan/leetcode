package leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1575 👎 0


import java.util.*;

public class LetterCombinationsOfAPhoneNumber_17 {

    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber_17().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) {
                return res;
            }
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            dfs(res, map, digits, 0, new StringBuffer());
            return res;
        }

        private void dfs(List<String> res, Map<Character, String> map, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                res.add(combination.toString());
                return;
            }
            char c = digits.charAt(index);
            String letters = map.get(c);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                dfs(res, map, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }

        public List<String> letterCombinations1(String digits) {
            LinkedList<String> ans = new LinkedList<>();
            if (digits.isEmpty()) {
                return ans;
            }
            String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ans.add("");
            for (int i = 0; i < digits.length(); i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                while (ans.peek().length() == i) {
                    String t = ans.remove();
                    for (char s : mapping[x].toCharArray()) {
                        ans.add(t + s);
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}