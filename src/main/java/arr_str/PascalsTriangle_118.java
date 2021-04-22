package arr_str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengjia
 * @date 2021-04-08 12:41:05
 */
public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    item.add(1);
                    continue;
                }
                List<Integer> pre = ans.get(i - 1);
                item.add(pre.get(j - 1) + pre.get(j));
            }
            ans.add(item);
        }
        return ans;
    }

    public List<Integer> getRow(int rowIndex) {
        int[] arr = new int[rowIndex + 1];
        // 每一行的第一项都是1
        arr[0] = 1;
        // 从第二行开始遍历
        for (int i = 1; i <= rowIndex; i++) {
            // 每一行的首尾都是1
            arr[0] = 1;
            arr[i] = 1;
            // 从第i行的倒数第二个开始遍历到第二个
            for (int j = i - 1; j >= 1; j--) {
                arr[j] = arr[j - 1] + arr[j];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i : arr) {
            res.add(i);
        }
        return res;
    }

    public List<Integer> recursion(int rowIndex) {
        int[][] memo = new int[rowIndex + 1][];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new int[i + 1];
        }

        for (int i = 0; i < rowIndex + 1; i++) {
            memo[rowIndex][i] = cal(rowIndex, i, memo);
        }
        List<Integer> res = new ArrayList<>();
        for (int i : memo[rowIndex]) {
            res.add(i);
        }
        return res;
    }

    public int cal(int i, int j, int[][] memo) {
        if (j == 0 || j == i) {
            return 1;
        }

        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        memo[i][j] = cal(i - 1, j - 1, memo) + cal(i - 1, j, memo);
        return memo[i][j];
    }

    public List<Integer> getRow3(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    public static void main(String[] args) {
        new PascalsTriangle_118().generate(5);
    }
}
