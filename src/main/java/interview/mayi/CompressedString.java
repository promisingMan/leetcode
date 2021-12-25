package interview.mayi;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zengjia
 * @date 2021-12-06 19:41:46
 */
// 题目1
// 字符串压缩指的是将一段原始字符串压缩成一段长度更短的压缩字符串，并且压缩字符串可以还原成原始字符串。如字符串"xxxrryyyyyyz"可以压缩成"x(3)r(2)y(6)z(1)"，括号中的数字表示前面字符的重复次数。
// 请实现一个数据结构类——压缩字符串（CompressedString），该类需要满足以下要求：
// 使用List<CompressedChar>类型的内部成员存储数据，CompressedChar的结构大致如下（可自己扩展需要的方法）：
// class CompressedChar {
//     int num;
//     char ch;
// }
// 提供一个构造函数CompressedString(String originStr)，输入一个原始字符串，创建一个压缩字符串。
// 提供String toString()成员方法，输出压缩字符串，输出样例：x(3)r(2)y(6)z(1)
// 提供String expand()成员方法，返回压缩前的原始字符串，不要在数据结构内直接存储原始字符串，否则失去了压缩节省空间的意义；
// 提供int charSize()成员方法，返回压缩字符串中的字符数，例如"x(3)r(2)y(6)z(1)"，字符数为4（x、r、y、z）
public class CompressedString {
    public static void main(String[] args) {
        CompressedString s = new CompressedString("xxxrryyyyyyzz");
        System.out.println(s.toString());
        System.out.println(s.expand());
        System.out.println(s.charSize());
        CompressedString s0 = new CompressedString(null);
        System.out.println(s0.toString());
        System.out.println(s0.expand());
        System.out.println(s0.charSize());
        CompressedString s1 = new CompressedString("");
        CompressedString s2 = new CompressedString("abcd");
        CompressedString s3 = new CompressedString("aabbddaa");
        System.out.println(s);
    }

    List<CompressedChar> compressions;
    int charSize;

    public CompressedString(String originStr) {
        if (originStr == null) {
            compressions = null;
            return;
        }
        int n = originStr.length();
        compressions = new ArrayList<>(n);
        boolean[] charArr = new boolean[256];
        int count = 1;
        for (int i = 1; i < n; i++) {
            char pre = originStr.charAt(i - 1);
            char cur = originStr.charAt(i);
            if (cur == pre) {
                count++;
            } else {
                compressions.add(new CompressedChar(count, pre));
                count = 1;
                if (!charArr[pre]) {
                    charArr[pre] = true;
                    charSize++;
                }
            }
            if (i == n - 1) {
                compressions.add(new CompressedChar(count, cur));
                if (!charArr[pre]) {
                    charArr[pre] = true;
                    charSize++;
                }
            }
        }
    }

    @Override
    public String toString() {
        if (compressions == null) {
            return null;
        }
        if (compressions.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (CompressedChar compression : compressions) {
            String str = MessageFormat.format("{0}({1})", compression.ch, compression.num);
            sb.append(str);
        }
        return sb.toString();
    }

    public String expand() {
        if (compressions == null) {
            return null;
        }
        if (compressions.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (CompressedChar compression : compressions) {
            for (int i = 0; i < compression.num; i++) {
                sb.append(compression.ch);
            }
        }
        return sb.toString();
    }

    public int charSize() {
        return charSize;
    }

    public static class CompressedChar {
        int num;
        char ch;

        public CompressedChar(int num, char ch) {
            this.num = num;
            this.ch = ch;
        }
    }
}
