package binary_search;

import java.text.MessageFormat;

/**
 * @author zengjia
 * @date 2021-04-01 09:10:37
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if (nums == null || nums.length == 0) {
            return range;
        }

        int l = 0;
        int r = nums.length - 1;

        int la = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (l != nums.length && nums[l] == target) {
            la = l;
        } else {
            return range;
        }

        int ra = -1;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                l = m + 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        ra = r;

        System.out.println(MessageFormat.format("{0}-{1}", la, ra));
        range[0] = la;
        range[1] = ra;
        return range;
    }
}
