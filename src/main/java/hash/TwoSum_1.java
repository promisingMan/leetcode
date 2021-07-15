package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zengjia
 * @date 2021-07-15 21:30:14
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = hashtable.get(target - nums[i]);
            if (index != null) {
                return new int[]{i, index};
            }
            hashtable.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        new TwoSum_1().twoSumHash(new int[]{3, 2, 4}, 6);
    }
}
