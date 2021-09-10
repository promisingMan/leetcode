package everyday;

/**
 * @author zengjia
 * @date 2021-09-10 01:42:14
 */
public class FindTheStudentThatWillReplaceTheChalk_1894 {
    /**
     * 自己写的
     *
     * @param chalk
     * @param k
     * @return
     */
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk) {
            sum += num;
        }
        long mod = k % sum;
        long a = 0;
        for (int i = 0; i < chalk.length; i++) {
            a += chalk[i];
            if (a > mod) {
                return i;
            }
        }
        return -1;
    }

    public int chalkReplacer1(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk) {
            sum += num;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return -1;
    }

    public int chalkReplacer2(int[] chalk, int k) {
        if (chalk[0] > k) {
            return 0;
        }

        for (int i = 1; i < chalk.length; i++) {
            chalk[i] = chalk[i - 1] + chalk[i];
            if (chalk[i] > k) {
                return i;
            }
        }

        k %= chalk[chalk.length - 1];

        int left = 0, right = chalk.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (chalk[mid] > k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
