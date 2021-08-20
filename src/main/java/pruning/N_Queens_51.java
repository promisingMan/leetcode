package pruning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zengjia
 * @date 2021-08-19 23:09:31
 */
public class N_Queens_51 {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        List<List<String>> results = new ArrayList<>();
        dfs(n, 0, new ArrayList<>(n), results, cols, pie, na);
        return results;
    }

    private void dfs(int n, int row, List<Integer> result, List<List<String>> results, Set<Integer> cols, Set<Integer> pie, Set<Integer> na) {
        if (row == n) {
            results.add(generateRes(n, result));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }

            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            result.add(col);

            dfs(n, row + 1, result, results, cols, pie, na);

            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            result.remove(row);
        }
    }

    private List<String> generateRes(int n, List<Integer> result) {
        return result.stream()
                .map(col -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        sb.append(col == i ? "Q" : ".");
                    }
                    return sb.toString();
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<String>> nQueens = new N_Queens_51().solveNQueens(4);
        System.out.println(nQueens);
    }
}
