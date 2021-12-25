package week;

import java.util.Arrays;

/**
 * @author zengjia
 * @date 2021-09-26 09:34:16
 */
public class Week261 {
    public static void main(String[] args) {
        Week261 w = new Week261();
    }

    public int minimumMoves(String s) {
        int res = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == 'X') {
                res++;
                i += 3;
            } else {
                i++;
            }
        }
        return res;
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int len = rolls.length;
        int total = mean * (n + len);
        int nt = total - sum;
        if (nt / 6 > n || (nt / 6 == n && nt % 6 > 0) || nt < n) {
            return new int[]{};
        }

        int[] res = new int[n];
        int i = 0;
        while (nt > 0) {
            res[i]++;
            nt--;
            i = (i + 1) % n;
        }

        return res;
    }
}
