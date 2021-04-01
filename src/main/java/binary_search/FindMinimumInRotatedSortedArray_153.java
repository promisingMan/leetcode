package binary_search;

/**
 * @author zengjia
 * @date 2021-04-01 09:08:21
 */
public class FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}
