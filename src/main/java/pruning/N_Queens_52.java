package pruning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zengjia
 * @date 2021-08-19 23:09:31
 */
public class N_Queens_52 {
    public Integer solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        return dfs(n, 0, new ArrayList<>(n), cols, pie, na);
    }

    private Integer dfs(int n, int row, List<Integer> result, Set<Integer> cols, Set<Integer> pie, Set<Integer> na) {
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }

            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            result.add(col);

            count += dfs(n, row + 1, result, cols, pie, na);

            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            result.remove(row);
        }

        return count;
    }

    public static void main(String[] args) {
        Integer nQueens = new N_Queens_52().solveNQueens(8);
        System.out.println(nQueens);
    }
}
