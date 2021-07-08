package arr_str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zengjia
 * @date 2021-07-08 20:36:51
 */
public class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int mod = 0;
        for (int i = 0; i < len; i++) {
            mod = (mod + nums[i]) % k;
            Integer index = map.get(mod);
            if (index != null) {
                if (i - index >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

    public boolean checkSubarraySum_1(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int[] sums = new int[len];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= len; i++) {
            set.add(sums[i - 2] % k);
            if (set.contains(sums[i] % k)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new ContinuousSubarraySum_523().checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7);
    }
}
