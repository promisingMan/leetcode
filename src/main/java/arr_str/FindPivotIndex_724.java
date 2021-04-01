package arr_str;

import java.util.Arrays;

/**
 * @author zengjia
 * @date 2021-03-31 23:21:23
 */
public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
