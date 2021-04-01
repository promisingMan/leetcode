package arr_str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zengjia
 * @date 2021-03-28 18:23:43
 */
public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N * M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }

    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] result = new int[m * n];
        int k = 0;

        // 保存对角线的值
        List<Integer> intermediate = new ArrayList<>();

        // 按先第一行再最后一列为起始的对角线开始遍历
        for (int i = 0; i < m + n - 1; i++) {
            int r = i < n ? 0 : i - n + 1;
            int c = i < n ? i : n - 1;

            intermediate.clear();

            while (r < m && c > -1) {
                intermediate.add(matrix[r++][c--]);
            }

            // 如果是奇数对角线
            if ((i + 1) % 2 == 1) {
                Collections.reverse(intermediate);
            }

            for (Integer e : intermediate) {
                result[k++] = e;
            }
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
//        new DiagonalTraverse_498().findDiagonalOrder2(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        new DiagonalTraverse_498().findDiagonalOrder2(new int[][]{{2, 3}});
    }
}
