package week;

/**
 * @author zengjia
 * @date 2021-09-18 22:40:09
 */
public class Week62 {
    public static void main(String[] args) {
        Week62 week62 = new Week62();
        week62.numOfPairs(new String[]{"777","7","77","77"}, "7777");
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (m * n < len || len <= (m - 1) * n || (m == 1 && len <= n)) {
            return new int[][]{};
        }
        int[][] res = new int[m][n];
        int i = 0, j = 0;
        for (int value : original) {
            if (j != n) {
                res[i][j] = value;
                j++;
            } else {
                i++;
                j = 0;
                res[i][j] = value;
                j++;
            }
        }
        return res;
    }

    public int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((nums[i] + nums[j]).equals(target) && i != j) {
                    res++;
                }
            }
        }
        return res;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return 0;
    }
}
