package arr_str.double_pointer;

import java.util.Arrays;

/**
 * @author zengjia
 * @date 2021-04-04 16:44:33
 */
public class ArrayPartitionI_561 {
    public int arrayPairSum(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}
