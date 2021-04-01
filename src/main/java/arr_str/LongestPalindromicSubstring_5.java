package arr_str;

/**
 * @author zengjia
 * @date 2021-03-30 20:18:12
 */
public class LongestPalindromicSubstring_5 {
    /**
     * 暴力解法1：子串由长到短开始逐一检测，如果是回文直接返回
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int n = len - 1;
        while (n >= 0) {
            for (int i = 0; i <= len - 1 - n; i++) {
                if (isPalindromic(s, i, i + n)) {
                    return s.substring(i, i + n + 1);
                }
            }
            n--;
        }
        return "";
    }

    /**
     * 暴力解法2：子串由短到长逐一检测，记录最长子串起始位置和长度
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && isPalindromic(s, i, j)) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 动态规划
     * dp[i][j] = (s[i] == s[j]) && (dp[i + 1][j - 1])
     * 表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
     * 这个结论很显然：j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;

        char[] chars = s.toCharArray();

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                    continue;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public boolean isPalindromic(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public String longestPalindrome4(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < len; i++) {
            // 奇数
            int len1 = expandAroundCenter(s, i, i);
            // 偶数
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxTemp = Math.max(len1, len2);
            if (maxTemp > maxLen) {
                begin = i - (maxTemp - 1) / 2;
                maxLen = maxTemp;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring_5 longestPalindromicSubstring_5 = new LongestPalindromicSubstring_5();
        String str = longestPalindromicSubstring_5.longestPalindrome4("ababa");
        System.out.println(str);
    }
}
