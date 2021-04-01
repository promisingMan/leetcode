package arr_str;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zengjia
 * @date 2021-03-28 17:24:29
 */
public class ZeroMatrixLCCI_面试题_01_08 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
        for (Integer col : cols) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        new ZeroMatrixLCCI_面试题_01_08().setZeroes(
                new int[][]{{0, 1, 2, 0},
                        {3, 4, 5, 2},
                        {1, 3, 1, 5}});
    }
}
