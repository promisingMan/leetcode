package binary_search;

/**
 * @author zengjia
 * @date 2021-04-01 08:55:32
 */
public class FirstBadVersion_278 {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public boolean isBadVersion(int num) {
        return true;
    }
}
