package leetcode.editor.cn;

//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 栈 贪心 字符串 动态规划 👍 338 👎 0


import java.util.Deque;
import java.util.LinkedList;

public class 有效的括号字符串_678 {
    public static void main(String[] args) {
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> asteriskStack = new LinkedList<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            }
            if (c == '*') {
                asteriskStack.push(i);
            }
            if (c == ')') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!leftStack.isEmpty()) {
            if (leftStack.size() > asteriskStack.size()) {
                return false;
            } else {
                while (!leftStack.isEmpty()) {
                    Integer leftIndex = leftStack.pop();
                    Integer asteriskIndex = asteriskStack.pop();
                    if (leftIndex > asteriskIndex) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean checkValidString_dp(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = s.charAt(i) == '*';
        }

        for (int i = 1; i < n; i++) {
            dp[i - 1][i] = (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '*') &&
                    (s.charAt(i) == ')' || s.charAt(i) == '*');
        }

        for (int i = n - 3; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 2; j < n; j++) {
                char c2 = s.charAt(j);
                if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                for (int k = i; k < j && !dp[i][j]; k++) {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }

        return dp[0][n - 1];
    }

    public boolean checkValidString2(String s) {
        int n = s.length();
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min = Math.max(min - 1, 0);
                max--;
                if (max < 0) {
                    return false;
                }
            } else {
                min = Math.max(min - 1, 0);
                max++;
            }
        }
        return min == 0;
    }

    public boolean checkValidString3(String s) {
        int n = s.length();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            left += s.charAt(i) == ')' ? -1 : 1;
            right += s.charAt(n - 1 - i) == '(' ? -1 : 1;
            if (left < 0 || right < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
