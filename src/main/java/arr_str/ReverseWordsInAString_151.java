package arr_str;

import java.util.*;

/**
 * @author zengjia
 * @date 2021-04-01 20:29:29
 */
public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = chars.length - 1; i >= 0; i--) {
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

    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        ReverseWordsInAString_151 reverseWordsInAString_151 = new ReverseWordsInAString_151();
        String s = reverseWordsInAString_151.reverseWords("Alice does not even like bo");
        System.out.println(s);
    }
}
