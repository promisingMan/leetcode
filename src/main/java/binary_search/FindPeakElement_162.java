package binary_search;

/**
 * @author zengjia
 * @date 2021-04-01 09:05:03
 */
public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        // 迭代
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;

        // 递归
        //return bs(l, r, nums);
    }

    public int bs(int l, int r, int[] nums) {
        if (l == r) {
            return l;
        }
        int m = l + (r - l) / 2;
        if (nums[m] > nums[m + 1]) {
            return bs(l, m, nums);
        }
        return bs(m + 1, r, nums);
    }
}
