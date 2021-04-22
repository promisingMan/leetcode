package arr_str;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zengjia
 * @date 2021-04-01 20:29:29
 */
public class ReverseWordsInAString_557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
            } else {
                stack.push(chars[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.charAt(sb.length() - 1) == ' ' ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int k;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                k = i - 1;
                while (k >= start) {
                    sb.append(s.charAt(k));
                    k--;
                }
                sb.append(' ');
                start = i + 1;
            }
        }
        k = s.length() - 1;
        while (k >= start) {
            sb.append(s.charAt(k));
            k--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString_557 reverseWordsInAString_151 = new ReverseWordsInAString_557();
        String s = reverseWordsInAString_151.reverseWords2("Let's take LeetCode contest");
        System.out.println(s);
    }
}
