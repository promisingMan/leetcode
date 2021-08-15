package binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs + 回溯 + 剪枝
 *
 * @author zengjia
 * @date 2021-08-14 22:28:44
 */
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
//        dfs("", n, n, res);
        dfs2("", n, 0, 0, res);
        return res;
    }

    private void dfs(String str, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0) {
            dfs(str + "(", left - 1, right, res);
        }
        if (right > left) {
            dfs(str + ")", left, right - 1, res);
        }
    }

    private void dfs2(String str, int n, int left, int right, List<String> res) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }

        if (left < n) {
            dfs2(str + "(", n, left + 1, right, res);
        }
        if (right < left) {
            dfs2(str + ")", n, left, right + 1, res);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new GenerateParentheses_22().generateParenthesis(2);
        System.out.println(strings);
    }
}
